package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Lab{
	int x;
	int y;
	public Lab(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class main14502ReRe {

	public static int N,M;
	public static int[][] arr,arr2;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		arr2 = new int[N+1][M+1];

		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(1);
					arr[i][j] = 0;
				}
			}
		}
		System.out.println(max);
	}
	private static void dfs(int cnt) {
		if(cnt == 3) {
			bfs();
			return;
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(cnt+1);
					arr[i][j] = 0;
				}
			}
		}
		
		
	}
	private static void bfs() {
		Queue<Lab> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				arr2[i][j] = arr[i][j];
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(arr2[i][j] == 2) {
					q.add(new Lab(i,j));
				}
			}
		}
		while(!q.isEmpty()) {
			Lab temp = q.poll();
			for(int i=0;i<4;i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx > 0 && ny > 0 && nx <= N && ny <= M) {
					if(arr2[nx][ny] == 0) {
						arr2[nx][ny]= 2;
						q.add(new Lab(nx,ny)); 
					}
				}
			}
		}
		int tempCnt = 0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(arr2[i][j] == 0) {
					tempCnt++;
				}
			}
		}
		if(tempCnt>max) {
			max = tempCnt;
		}
	}
}
