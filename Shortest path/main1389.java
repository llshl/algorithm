package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main1389 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N,M;
		int INF = (int)1e9;
		StringTokenizer st = new StringTokenizer(br.readLine()," "); 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][N+1];
		
		for(int i=0;i<=N;i++) {		//일단 다 INF로 초기화
			Arrays.fill(arr[i],INF);
		}
		
		for(int i=0;i<=N;i++) {		//대각선은 0
			arr[i][i] = 0;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," "); 
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;	//양방향
		}
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		int ans = INF;
		int index = -1;
		int[] dap = new int[N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				dap[i] += arr[i][j];
			}
			if(ans > dap[i]) {
				ans = dap[i];
				index = i;
			}
		}
		System.out.println(index);
	}
}
