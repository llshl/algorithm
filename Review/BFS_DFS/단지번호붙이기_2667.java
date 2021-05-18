package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기_2667 {

	public static int N, answer = 0, cnt = 0;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int[][] arr;
	public static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String[] temp = br.readLine().split("");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.valueOf(temp[j]);
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j] == false && arr[i][j] != 0) {
					answer++;
					dfs(i,j);
					list.add(cnt);
					cnt = 0;
				}
			}
		}
		System.out.println(answer);
		Collections.sort(list);
		for(int a : list) {
			System.out.println(a);
		}
	}
	private static void dfs(int x, int y) {
		cnt++;
		visit[x][y] = true;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(inBound(nx,ny)) {
				if(visit[nx][ny] == false && arr[nx][ny] == 1) {
					dfs(nx,ny);
				}
			}
		}
	}
	private static boolean inBound(int nx, int ny) {
		if(nx>=0&&ny>=0&&nx<N&&ny<N) {
			return true;
		}
		return false;
	}
}
