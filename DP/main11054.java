package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main11054 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int[] dpup = new int[1001];
		int[] dpdown = new int[1001];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++) {
			dpup[i] = 1;
			for(int j=1;j<i;j++) {
				if(arr[i] > arr[j]) {
					dpup[i] = Math.max(dpup[i], dpup[j]+1);
				}
			}
		}
		for(int i=N;i>0;i--) {
			dpdown[i] = 1;
			for(int j=N;j>i;j--) {
				if(arr[i] > arr[j]) {
					dpdown[i] = Math.max(dpdown[i], dpdown[j]+1);
				}
			}
		}
		int max = -1;
		for(int i=1;i<=N;i++) {
			dpup[i] += dpdown[i] ;
			if(dpup[i] > max) {
				max = dpup[i];
			}
		}
		System.out.println(max-1);
	}
}
