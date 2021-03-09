package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main1010 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int[][] dp = new int[30][30];
			for(int i=0;i<30;i++) {
				dp[i][i] = 1;	//n개중에 n개 뽑는경우
				dp[i][0] = 1;	//n개중에 0개 뽑는경우
			}
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for(int i=2;i<30;i++) {
				for(int j=1;j<30;j++) {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
			System.out.println(dp[c][n]); 
		}
	}
}
