package NDBsAlgorithm;

import java.util.Scanner;

public class DP_Tile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[100];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=N;i++) {
			dp[i] = dp[i-1] + 2*dp[i-2];
		}
		System.out.println(dp[N]);
	}

}
