package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main11722Re {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int[] dp = new int[1001];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=N;i>0;i--) {	//감소하는 수열은 즉 뒤쪽부터 증가하는 수열이므로 for문을 거꾸로돌린다
			dp[i] = 1;
			for(int j=N;j>i;j--) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
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
