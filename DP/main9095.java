package DP;

import java.util.Scanner;

public class main9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int T = sc.nextInt();
		int n;
		int[] dp = new int[11];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		//for(int i=0;i<T;i++) {
			n = sc.nextInt();
			//if(n>2) {
			for(int j=3;j<=n;j++) {
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
			}
			//}
			System.out.println(dp[n-1]);
		//}
	}
}
