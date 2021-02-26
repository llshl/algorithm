package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main11724dfs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		boolean[] visit = new boolean[N+1];
		visit[0] = true;
		int[][] arr = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		for(int i=1;i<N+1;i++) {
			if(visit[i] == false) {
				dfs(i,arr,visit);
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static void dfs(int x, int[][] arr, boolean[] visit) {
		visit[x] = true;
		for(int i=1;i<arr.length;i++) {
			if(arr[x][i] == 1 && visit[i] == false) {
				dfs(i,arr,visit);
			}
		}
	}
}
