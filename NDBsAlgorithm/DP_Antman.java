package NDBsAlgorithm;

import java.util.Scanner;

public class DP_Antman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int[] dp = new int[100];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		for(int i=2;i<N;i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]);
		}
		System.out.println(dp[N-1]);
	}

}
