package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Àû·Ï»ö¾à_10026 {
	static int N;
	static int answer1 = 0;
	static int answer2 = 0;
	static char currentChar;
	static char[][] arr;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N+1][N+1];
		for(int i=1;i<=N;i++) {
			String temp = br.readLine();
			for(int j=1;j<=N;j++) {
				arr[i][j] = temp.charAt(j-1);
			}
		}
		answer();
	}
	
	private static void answer() {
		visit = new boolean[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(!visit[i][j]) {
					dfs(i,j);
					answer1++;
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(arr[i][j] == 'R') {
					arr[i][j] = 'G';
				}
			}
		}
		
		visit = new boolean[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(!visit[i][j]) {
					dfs(i,j);
					answer2++;
				}
			}
		}
		System.out.println(answer1+" "+answer2);
	}
	
	private static void dfs(int x, int y) {
		visit[x][y] = true;
		currentChar = arr[x][y];
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(inBound(nx,ny)) {
				if(!visit[nx][ny]) {
					if(currentChar == arr[nx][ny]) {
						dfs(nx,ny);
					}
				}
			}
		}
	}

	private static boolean inBound(int nx, int ny) {
		if(nx>=1&&ny>=1&&nx<=N&&ny<=N) {
			return true;
		}
		return false;
	}

}
