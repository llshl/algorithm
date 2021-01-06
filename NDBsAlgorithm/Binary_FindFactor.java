package NDBsAlgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Binary_FindFactor {
	public static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int M =sc.nextInt();
		int[] arr2 = new int[M];
		for(int i=0;i<M;i++) {
			arr2[i] = sc.nextInt();
		}
		for(int i=0;i<M;i++) {
			boolean flag = false;
			flag = binarysearch(arr2[i]);
			if(flag == true) {
				System.out.print("yes"+" ");
			}
			else {
				System.out.print("no"+" ");
			}
		}
	}

	private static boolean binarysearch(int x) {
		int first = 0;
		int last = arr.length-1;
		int mid = (first+last)/2;
		while(first<=last) {
			mid = (first+last)/2;
			if(arr[mid] == x) {
				return true;
			}
			else {
				if(arr[mid] < x) {
					first = mid+1;
				}
				else {
					last = mid-1;
				}
			}
		}
		return false;
	}

}
