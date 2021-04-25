package All;

import java.util.Arrays;

class GAME {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int indexA = 0;
        int indexB = 0;
        while(true) {
        	if(indexB == B.length) {
        		break;
        	}
        	
        	if(A[indexA] < B[indexB]) {
        		answer++;
        		indexA++;
        		indexB++;
        	}
        	else{
        		indexB++;
        	}
        }
        return answer;
    }
}


public class 숫자게임 {

	public static void main(String[] args) {
		GAME s = new GAME();
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
//		int[] A = {1,2,3,4};
//		int[] B = {1,2,3,4};
		System.out.println(s.solution(A, B));

	}

}
