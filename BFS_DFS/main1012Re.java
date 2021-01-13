package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main1012Re {
	public static int T;
	public static int N;
	public static int M;
	public static int K;
	public static int cnt=0;
	public static int[][] arr;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			String[] temp = br.readLine().split(" ");
			M = Integer.parseInt(temp[0]);	//가로
			N = Integer.parseInt(temp[1]);	//세로
			K = Integer.parseInt(temp[2]);	//개수
			arr = new int[N][M];
			for(int i=0;i<K;i++) {
				temp = br.readLine().split(" ");
				arr[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = 1;
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j] == 1) {
						arr[i][j] = 1;
						dfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
			cnt = 0;
		}
	}

	private static void dfs(int x, int y) {
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}
			if(arr[nx][ny] == 1) {	//1이라면
				arr[nx][ny] = 0;	//0으로 만든다
				dfs(nx,ny);
			}
		}
	}
}
