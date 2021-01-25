package DP;

import java.util.Scanner;

public class main1904 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=N;i++) {
			dp[i] = (dp[i-1]%15746+dp[i-2]%15746)%15746;
		}
		System.out.println(dp[N]);
	}
}
