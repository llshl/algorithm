package temp;

import java.util.Scanner;

public class ÆÄ½ºÄ®ÀÇ»ï°¢Çü {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N+2][N+2];
			arr[1][1] = 1;
			for(int i=2;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
				}
			}
			System.out.println("#"+t);
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(arr[i][j] != 0) {
						System.out.print(arr[i][j]+" ");
					}
				}
				System.out.println("");
			}
		}
	}
}
