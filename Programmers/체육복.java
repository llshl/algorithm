package Greedy;

import java.util.Arrays;

class S {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] entire = new int[n];
        Arrays.fill(entire, 1);
        for(int i=0;i<reserve.length;i++) {
        	entire[reserve[i]-1]++;
        }
        for(int i=0;i<lost.length;i++) {
        	entire[lost[i]-1]--;
        }
        for(int i=0;i<entire.length;i++) {
        	try {
        		if(entire[i] == 0 && entire[i+1] == 2) {
	        		entire[i+1]--;
	        		entire[i]++;
	        	}
	        	else if(entire[i] == 0 && entire[i-1] == 2) {
	        		entire[i-1]--;
	        		entire[i]++;
	        	}
        	}catch(Exception e) {
        		continue;
        	}
        }
        for(int a : entire) {
        	if(a == 0) {
        		answer++;
        	}
        	System.out.print(a+" ");
        }
        return n-answer;
    }
}

public class Ã¼À°º¹ {

	public static void main(String[] args) {
		S s = new S();
//		int n = 3;
//		int[] lost = {3};
//		int[] reserve = {1};
		int n = 6;
		int[] lost = {1,6};
		int[] reserve = {3};
		int answer = s.solution(n, lost, reserve);
		System.out.println("");
		System.out.println(answer);
	}

}
