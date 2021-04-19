package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main1915 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1];
		int[][] dp = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			String[] temp = br.readLine().split("");
			for(int j=1;j<=M;j++) {
				arr[i][j] = Integer.parseInt(temp[j-1]);
				if(arr[i][j]==1) {
					dp[i][j] = 1;
				}
			}
		}
		int answer = 0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(arr[i-1][j-1]==1 && arr[i][j-1]==1 && arr[i-1][j]==1) {
					System.out.println("i: "+i+" ,j: "+j);
					dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]);
					dp[i][j] = Math.min(dp[i][j], dp[i][j-1])+1; 
				}
				answer = Math.max(answer , dp[i][j]);
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				System.out.print(dp[i][j]);
			}
			System.out.println("");
		}
		System.out.println((answer)*(answer));
	}
}
