package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main2156ReReRe {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if(N==1) {
			System.out.println(arr[1]);
			return;			
		}
		int[] dp = new int[N+1];
		dp[1] = arr[1];
		dp[2] = arr[2]+arr[1];
		for(int i=3;i<=N;i++) {
			dp[i] = Math.max(Math.max(arr[i]+dp[i-2], arr[i]+arr[i-1]+dp[i-3]),dp[i-1]);
		}
		int answer = 0;
		for(int a : dp) {
			if(answer < a) {
				answer = a;
			}
		}
		System.out.println(answer);
	}
}
