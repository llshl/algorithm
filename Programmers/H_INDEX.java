package Sorting;

import java.util.Arrays;

class Sol {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++) {
        	int cnt = citations.length-i;
        	if(citations[i] >= cnt) {
        		answer = cnt;
        		break;
        	}
        }
        return answer;
    }
}
//0 1 3 5 6
public class H_INDEX {

	public static void main(String[] args) {
		Sol s = new Sol();
		int[] citations = {0,1,2,3,4,4,4,5};
		int answer = s.solution(citations);
		System.out.println(answer);
	}
}
//[12, 11, 10, 9, 8, 1] 5
//[6, 6, 6, 6, 6, 1] 5		1,6,6,6,6,6
//[4, 4, 4] 3
//[4, 4, 4, 5, 0, 1, 2, 3] 4
//[10, 11, 12, 13] 4
//[3, 0, 6, 1, 5] 3
//[0, 0, 1, 1] 1
//[0, 1] 1
//[10, 9, 4, 1, 1] 3		1,1,4,9,10
