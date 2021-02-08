package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main11403_Flo {
	public static int N;
	public static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(arr[i][k] == 1 && arr[k][j] == 1) {	//i->k로 가는길이 있고 k->j로 가는길이 있다면 i->j로 가는길이 있다
						arr[i][j] = 1;
					}
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}

}
