package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main1937dfs {

	public static int N; 
	public static int[][] arr,dp;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for(int i=0;i<N;i++) {			
			for(int j=0;j<N;j++) {
				answer = Math.max(dfs(i,j),answer);
			}
		}
		System.out.println(answer);
	}
	private static int dfs(int x, int y) {
		if(dp[x][y] != 0) {
			return dp[x][y];
		}
		int answer = 1;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(arr[nx][ny] > arr[x][y]) {
					answer = Math.max(dfs(nx,ny)+1,answer);
					dp[x][y] = answer;
				}
			}
		}
		return answer;
	}

}
