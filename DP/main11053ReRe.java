package DP;

import java.util.Scanner;

public class main11053ReRe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int[] dp = new int[N];
		dp[0] = 1;
		for(int i=1;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[j]+1,dp[j]);
				}
				if(dp[i]==0 && j==i-1) {
					dp[i] = 1;
				}
			}
		}
		int answer = 0;
		for(int a : dp) {
			System.out.print(a+" ");
			if(answer<a) {
				answer = a;
			}
		}
		System.out.println(answer);
	}
}
