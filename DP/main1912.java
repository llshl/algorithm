package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main1912 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[100001];
		int[] dp = new int[100001];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];
		for(int i=1;i<N;i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
		}
		int M = arr[0];
		for(int i=0;i<N;i++) {
			if(M < dp[i]) {
				M = dp[i];
			}
		}
		System.out.println(M);
	}
}
