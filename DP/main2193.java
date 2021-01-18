package DP;

import java.math.BigInteger;
import java.util.Scanner;

public class main2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger[] arr = new BigInteger[91];
		arr[0] = BigInteger.ONE;	//arr[0]은 지금 1로 고정이 되었으므로 [1]까지 가능한 누적합은 1이다(1다음에 또 1은 안되니까)
		arr[1] = BigInteger.ONE;
		for(int i=2;i<n;i++) {
			arr[i] = arr[i-1].add(arr[i-2]);
		}
		System.out.println(arr[n-1]);
	}
}
