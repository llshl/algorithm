package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main11404 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int INF = (int)1e9;
		int[][] arr = new int[N+1][N+1];
		
		for(int i=0;i<=N;i++) {
			Arrays.fill(arr[i], INF);
		}
		
		for(int i=0;i<=N;i++) {
			arr[i][i] = 0;
		}
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = Math.min(arr[a][b], c);
		}
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
			
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(arr[i][j] < INF) {
					System.out.print(arr[i][j]+" ");
				}
				else {
					System.out.print(0+" ");
				}
			}
			System.out.println("");
		}
	}
}
