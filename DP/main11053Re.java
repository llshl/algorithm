package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main11053Re {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int[] dp = new int[1001];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++) {
			dp[i] = 1;	//자기자신 자체로 일단 길이가 1인 수열이므로 1로 초기화하고 시작한다.
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);	//dp[i]이전의 값들중 제일큰값에서 +1한 값을 새로 갱신해서 넣는다
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
