package BinarySearch;

import java.io.IOException;
import java.util.Scanner;

public class main2512 {

	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int sum = 0;
		cnt = sc.nextInt();
		int[] arr = new int[cnt];
		for(int i=0;i<cnt;i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		int M = sc.nextInt();
		if(sum<=M) {
			System.out.println(max);
		}
		else {
			System.out.println(ans(arr,M));
		}
	}

	private static int ans(int[] arr,int M) {
		int first = 0;
		int last = M;
		int mid = (first+last)/2;
		int ans = 0;
		while(first<=last) {
			mid = (first+last)/2;
			if(verify(arr,mid)<=M) {
				ans = mid;
				first = mid+1;	//로 한번더실행
			}
			else {
				last = mid-1;
			}
		}
		return ans;
	}

	private static int verify(int[] arr, int mid) {
		int total = 0;
		for(int i=0;i<cnt;i++) {
			if(arr[i] > mid) {
				total += mid;
			}
			else {
				total += arr[i];
			}
		}
		return total;
	}
}
