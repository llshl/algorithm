package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class main1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int cnt = 0;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[]a, int[]b) {
				if(a[1]==b[1]) {
					return a[0]-b[0];
				}
				return a[1]-b[1];
			}
		});
		int end = -1;
		for(int i=0;i<N;i++) {
			if(arr[i][0] >= end) {
				cnt++;
				end = arr[i][1];
			}
		}
		System.out.println(cnt);
	}
}
