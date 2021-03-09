package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//매 수행마다 dfs로 내부공간 체크
/*for(int i=0;i<N;i++) {
	for(int j=0;j<M;j++) {
		System.out.print(arr[i][j]);
	}
	System.out.println("");
}*/
public class main2638dfs {

	public static int N,M; 
	public static int[][] arr;
	public static boolean[][] innerVisit;
	public static boolean flag = false;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
		checkInnerPlace();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println("");
		}
	}
	private static void checkInnerPlace() {
		innerVisit = new boolean[N][M];
		for(int i=1;i<N-1;i++) {
			for(int j=1;j<M-1;j++) {
				innerDfs(i,j);
				if(arr[i][j] == 0 && !flag) {
					changeInner();
				}
				flag = false;
			}
		}
		
	}
	private static void changeInner() {
		for(int i=1;i<N-1;i++) {
			for(int j=1;j<M-1;j++) {
				if(innerVisit[i][j] == true) {
					arr[i][j] = 2;
				}
			}
		}
		
	}
	private static void innerDfs(int x, int y) {
		if(innerVisit[x][y] == false) {
			innerVisit[x][y] = true;
			if(x == 0 || x == N-1 || y == 0 || y == M) {
				flag = true;
				return;
			}
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if(arr[nx][ny] == 0) {
						innerDfs(nx,ny);
					}
				}
			}
		}
	}
}
