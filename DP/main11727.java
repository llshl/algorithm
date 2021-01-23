package DP;

import java.util.Scanner;

public class main11727 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N];
		dp[0] = 1;
		dp[1] = 3;
		for(int i=2;i<N;i++) {
			dp[i] = (dp[i-1]%10007 + (2*dp[i-2])%10007)%10007;
		}
		System.out.println(dp[N-1]);
	}
}
