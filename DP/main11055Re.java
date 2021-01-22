package DP;

import java.util.Scanner;

public class main11055Re {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[1001];
		int[] dp = new int[1001];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			int max = -1;
			dp[i] = arr[i];
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j] && max < dp[j]) {
					max = dp[j];
					dp[i] = arr[i] + max;
				}
			}
		}
		int M = -1;
		for(int i=0;i<N;i++) {
			if(M < dp[i]) {
				M = dp[i];
			}
		}
		System.out.println(M);
	}
}
