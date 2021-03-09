package DP;

import java.util.Scanner;

public class main1904Re {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[1000001];
		dp[0] = 1;
		dp[1] = 2;
		for(int i=2;i<N;i++) {
			dp[i] = ((dp[i-1]%15746) + (dp[i-2]%15746))%15746;
		}
		System.out.println(dp[N-1]);
	}
}
