package DP;

import java.math.BigInteger;
import java.util.Scanner;

public class main2748 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger[] arr = new BigInteger[91];
		arr[0] = BigInteger.ZERO;
		arr[1] = BigInteger.ONE;
		for(int i=2;i<=n;i++) {
			arr[i] = arr[i-1].add(arr[i-2]);
		}
		System.out.println(arr[n]);
	}
}
