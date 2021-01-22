package DP;

import java.util.Scanner;

public class main2156ReRe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[10001];
		int[] dp = new int[10001];
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		int max = -1;
		for(int i=3;i<=n;i++) {
			dp[i] = Math.max(arr[i]+arr[i-1]+dp[i-3], Math.max(dp[i-1], arr[i]+dp[i-2]));
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
