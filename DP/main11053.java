package DP;

import java.io.IOException;
import java.util.Scanner;

public class main11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				//dp[i] < dp[j]+1의 의미는 자기보다 앞의 dp들 중에서 가장 큰값에 +1을 해서 새로 넣겟다는것
				if(arr[j] < arr[i] && dp[i] < dp[j]+1) {	//그 다음 숫자가 더 큰경우(증가하는경우)
					dp[i] = Math.max(dp[i], dp[j]+1);
					//dp[i] = dp[j]+1;
				}
			}
		}
		int max = -1;
		for(int i=0;i<N;i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
