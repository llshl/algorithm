package Stack_Queue;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution3 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<priorities.length;i++) {
        	pq.add(priorities[i]);
        }
        
        while(!pq.isEmpty()) {
        	for(int i=0;i<priorities.length;i++) {
            	if(pq.peek() == priorities[i]) {
            		pq.poll();
            		answer++;
            		if(i == location) {
            			pq.clear();
            			break;
            		}
            	}
            }
        }
        return answer;
    }
}

public class ÇÁ¸°ÅÍ {

	public static void main(String[] args) {
		Solution3 solution = new Solution3();
//		int[] priorities = {2,1,3,2};
//		int location = 2;
		int[] priorities = {1,1,9,1,1,1};
		int location = 0;
		int answer = solution.solution(priorities, location);
		System.out.println(answer);
	}

}
