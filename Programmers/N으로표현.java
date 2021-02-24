package All;

import java.util.LinkedList;
import java.util.Queue;

class Now{
	int value;
	int times;
	public Now(int value, int times) {
		this.value = value;
		this.times = times;
	}
}

class makeN {
    public int solution(int N, int number) {
        int answer = 0;
        Queue<Now> q = new LinkedList<>();
        q.add(new Now(N,0));
        while(!q.isEmpty()) {
        	Now now = q.poll();
        	int value = now.value;
        	int time = now.times;
        	if(time >= 9) {
        		answer = -1;
        		break;
        	}
        	if(value == number) {
        		answer = time;
        		break;
        	}
        	if(value > 0 && value <= 32000)
	        	for(int i=0;i<5;i++) {
	        		if(i == 0) {
	        			//+5
	        			q.add(new Now(value+N,time+1));
	        		}
	        		else if(i == 1) {
	        			//-5
	        			q.add(new Now(value-N,time+1));
	        		}
	        		else if(i == 2) {
	        			//*5
	        			q.add(new Now(value*N,time+1));
	        		}
	        		else if(i == 3) {
	        			///5
	        			q.add(new Now(value/N,time+1));
	        		}
	        		else {
	        			//5
	        			String temp = value+"";
	        			temp += N+"";
	        			q.add(new Now(Integer.parseInt(temp),time+1)); 
	        		}
	        	}
        }
        return answer+1;
    }
}

public class N으로표현 {

	public static void main(String[] args) {
		makeN s = new makeN();
		int N = 8;
		int number = 53;
		System.out.println(s.solution(N, number));
	}
}
