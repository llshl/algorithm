package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class main11055 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		int[] dp = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++) {
			int max = 0;
			dp[i] = arr[i];
			for(int j=1;j<i;j++) {
				if(arr[i] > arr[j] && max < dp[j]) {
					dp[i] = dp[j] + arr[i];
					max = dp[j];
				}
			}
		}
		int max = -1;
		for(int i=1;i<=N;i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
