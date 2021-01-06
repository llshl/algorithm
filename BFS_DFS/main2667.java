package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class main2667 {

	public static int N;
	public static int cnt = 0;
	public static int danji=0;
	public static int[][] arr;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static boolean flag = false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}
		int area = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] == 1) {
					danji++;
					area = dfs(i,j);
					list.add(area);
					cnt = 0;
				}
			}
		}
		System.out.println(danji);
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}

	}

	private static int dfs(int x, int y) {
		arr[x][y] = 2;	//방문표시
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!(nx<0||ny<0||nx>=N||ny>=N)) {
				if(arr[nx][ny] == 1) {
					cnt++;
					dfs(nx,ny);
				}
			}
		}	
		return cnt+1;
	}
}
