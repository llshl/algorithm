package DP;

import java.util.Scanner;

public class main11057 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] dp = new long[1001][10];	//new long[1001][10];
		for(int i=0;i<10;i++) {
			dp[1][i] = 1;
		}
		for(int i=2;i<=N;i++) {
			for(int j=0;j<10;j++) {
				for(int k=0;k<=j;k++) {
					dp[i][j] += dp[i-1][k]%10007;
					dp[i][j] = dp[i][j]%10007;
				}
			}
		}
		int ans = 0;
		for(int i=0;i<10;i++) {
			ans += dp[N][i];
		}
		System.out.println(ans%10007);
	}
}
