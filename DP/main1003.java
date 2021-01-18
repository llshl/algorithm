package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main1003 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i1=0;i1<T;i1++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[41][2];
			arr[0][0] = 1;	//fibo(0)일때 0의 호출횟수
			arr[0][1] = 0;	//fibo(0)일때 1의 호출횟수
			arr[1][0] = 0;	//fibo(1)일때 0의 호출횟수
			arr[1][1] = 1;	//fibo(1)일때 1의 호출횟수
			if(n==0) {
				System.out.println(1+" "+0);
				continue;
				
			}
			if(n==1) {
				System.out.println(0+" "+1);
				continue;
			}
			for(int i=2;i<=n;i++) {
				for(int j=0;j<2;j++) {
					arr[i][j] = arr[i-1][j] + arr[i-2][j];
				}
			}
			System.out.println(arr[n][0]+" "+arr[n][1]);
		}
	}
}
