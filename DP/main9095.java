package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int n = Integer.parseInt(br.readLine());
			for(int j=4;j<=n;j++) {
				dp[j] = dp[j-1]+dp[j-2]+dp[j-3];
			}
			System.out.println(dp[n]);
		}
	}
}
