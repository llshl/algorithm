package DP;

import java.io.IOException;
import java.util.Scanner;

public class main1932 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);	
		int N = sc.nextInt();
		int[][] arr = new int[501][501];
		int[][] dp = new int[501][501];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<i+1;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dp[0][0] = arr[0][0];
		dp[1][0] = arr[1][0];
		dp[1][1] = arr[1][1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<i+1;j++) {
				dp[i][j] = arr[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
		}
		int max = dp[N][0];
		for(int i=1;i<=N;i++) {
			if(max <= dp[N][i]) {
				max = dp[N][i];
			}
		}
//		for(int i=1;i<=N;i++) {
//			for(int j=1;j<=N;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println("");
//		}
		System.out.println(max);
	}
}
