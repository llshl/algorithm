package All;

import java.util.PriorityQueue;

class Hot {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++) {
        	pq.add(scoville[i]);
        }
        while(!(pq.peek() >= K)) {
        	try {
	        	int min = pq.poll();
	        	int min2 = pq.poll();
	        	pq.add(min+min2*2);
	        	answer++;
        	}catch(Exception e) {
        		answer = -1;
        		break;
        	}
        }
        return answer;
    }
}

public class ´õ¸Ê°Ô {

	public static void main(String[] args) {
		Hot s = new Hot();
		int[] sco = {1,2,3,9,10,12};
		int K = 999;
		System.out.println(s.solution(sco, K));

	}

}
