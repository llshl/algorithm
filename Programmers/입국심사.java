package BinarySearch;

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 1;
        long end = (long)times[times.length-1]*n;
        long answer = end;
        long sum = 0;
        long mid = 0;
        while(start <= end) {
        	sum = 0;
        	mid = (start+end)/2;
        	for(int a : times){
        		sum += mid/a;
        	}
        	if(sum>=n) {
        		if(mid < answer) {
        			answer = mid;
        		}
        		end = mid-1;
        	}
        	else {
        		start = mid+1;
        	}
        }
        return answer;
    }
}

public class 입국심사 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 6;
		int[] times = {7,10};
		long answer = s.solution(n, times);
		System.out.println(answer);

	}

}
