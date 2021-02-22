package All;

import java.util.LinkedList;
import java.util.Queue;

class Case{
	int value;
	int stage;
	public Case(int value, int stage) {
		this.value = value;
		this.stage = stage;
	}
}

class Target {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Case> q = new LinkedList<>();
        q.add(new Case(numbers[0],0));
        q.add(new Case((-1)*numbers[0],0));
        while(!q.isEmpty()) {
        	Case temp = q.poll();
        	int value = temp.value;
        	int stage = temp.stage;
        	if(stage < numbers.length) {
        		if(stage == numbers.length-1 && value == target) {
        			answer++;
        		}
        		try {
	        		q.add(new Case(value + numbers[stage+1], stage+1));
	        		q.add(new Case(value + (-1)*numbers[stage+1], stage+1));
        		}catch(Exception e) {
        			continue;
        		}
        	}
        }
        return answer;
    }
}

public class Å¸°Ù³Ñ¹öbfs {

	public static void main(String[] args) {
		Target s = new Target();
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		int answer = s.solution(numbers, target);
		System.out.println(answer);
	}

}
