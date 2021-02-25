package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main2468dfs {

	public static int[][] arr;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int depth = 0;
		int answer = -1;
		int max = 0;
		while(answer != 0) {
			//물에 다 잠기면 break
			answer = step(depth);
			depth++;
			if(max < answer) {
				max = answer;
			}
		}
		System.out.println(max);
	}
	private static int step(int depth) {
		boolean[][] visit = new boolean[arr.length][arr.length];
		int cnt = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(visit[i][j] == false && arr[i][j] > depth) {	//물에 안잠기는 지역개수 카운트
					dfs(i,j,depth,visit,arr);
					cnt++;
				}
			}
		}
		return cnt;
	}
	private static void dfs(int x, int y, int depth, boolean[][] visit, int[][] arr) {
		visit[x][y] = true;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < arr.length && ny < arr.length) {
				if(visit[nx][ny] == false && arr[nx][ny] > depth) {
					dfs(nx,ny,depth,visit,arr);
				}
			}
		}
	}
}
