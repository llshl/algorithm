package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class main1654 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[K];
		int min = Integer.MAX_VALUE;
		for(int i=0;i<K;i++) {
			arr[i] = sc.nextInt();
			min = Math.min(min, arr[i]);
		}
		Arrays.sort(arr);
		long answer = binary(arr,N);
		System.out.println(answer);
	}

	private static long binary(int[] arr, int N) {
		long temp = 0;
		long start = 1;
		long end = arr[arr.length-1];
		long mid = -1;
		while(start <= end) {
			mid = (start+end)/2;
			temp = 0;
			for(int i=0;i<arr.length;i++) {
				temp += arr[i]/mid;
			}
			if(temp < N) {	//너무 길게 잘랐다.
				end = mid-1;
			}
			else if(temp >= N) {	//너무 짧다
				start = mid+1;
			}
		}
		return end;
	}
}
