package Stack_Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int dayCount = 1;
        int[] ansCount = new int[101];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<progresses.length;i++) {
        	q.add(progresses[i]);
        }
        for(int i=0;i<speeds.length;i++) {
        	while(true) {
	        	if(q.peek() + speeds[i]*dayCount >= 100) {
	        		q.poll();
	        		ansCount[dayCount]++;
	        		break;
	        	}
	        	dayCount++;
        	}
        } 
		/*
		 * List<Integer> list = new ArrayList<>(); for(int a : ansCount) { if(a != 0) {
		 * list.add(a); } } answer = new int[list.size()]; for(int
		 * i=0;i<list.size();i++) { answer[i] = list.get(i); }
		 */
        return Arrays.stream(ansCount).filter(a -> a!=0).toArray();
    }
}

public class 기능개발 {

	public static void main(String[] args) {
//		int[] progresses = {93,39,55};
//		int[] speeds = {1,30,5};
		int[] progresses = {95,90,99,99,80,99};
		int[] speeds = {1,1,1,1,1,1};
		int[] ans;
		Solution solution = new Solution();
		ans = solution.solution(progresses, speeds);
		for(int a : ans) {
			System.out.println(a);
		}
	}

}
