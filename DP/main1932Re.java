package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main1932Re {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		int[][] dp = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[1][1] = arr[1][1];
		for(int i=2;i<=N;i++) {
			for(int j=1;j<=i;j++) {
				if(j==1) {
					dp[i][j] = dp[i-1][j]+arr[i][j];
				}
				else if(j==i) {
					dp[i][j] = dp[i-1][j-1]+arr[i][j];
				}
				else {
					dp[i][j] = Math.max(arr[i][j]+dp[i-1][j-1], arr[i][j]+dp[i-1][j]);
				}
			}
		}
		int answer = 0;
		for(int a : dp[N]) {
			if(answer<a) {
				answer = a;
			}
		}
		System.out.println(answer);
	}
}
