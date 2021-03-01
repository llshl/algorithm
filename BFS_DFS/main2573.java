package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Ice{
	int x;
	int y;
	public Ice(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class main2573 {

	public static int N,M;
	public static int answer = 0;
	public static int piece = 0;
	public static int[][] arr;
	public static int[][] temp;
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {-0,0,-1,1};
	public static boolean flag = false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<M+1;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i=1;i<N+1;i++) {
//			for(int j=1;j<M+1;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println("");
//		}
		
		while(true) {
			answer++;
			temp = new int[N+1][M+1];
			visit = new boolean[N+1][M+1];
			flag = false;
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<M+1;j++) {
					if(arr[i][j] != 0) {
						bfs(i,j);
						flag = true;
					}
				}
			}
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<M+1;j++) {
					if(arr[i][j] - temp[i][j] <= 0) {
						arr[i][j] = 0;
					}
					else {
						arr[i][j] = arr[i][j] - temp[i][j];
					}
				}
			}
//			System.out.println("");
//			System.out.println("뺄 배열");
//			for(int i=1;i<N+1;i++) {
//				for(int j=1;j<M+1;j++) {
//					System.out.print(temp[i][j]+" ");
//				}
//				System.out.println("");
//			}
//			System.out.println("");
//			System.out.println("결과배열");
//			for(int i=1;i<N+1;i++) {
//				for(int j=1;j<M+1;j++) {
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println("");
//			}
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<M+1;j++) {
					if(arr[i][j] != 0 && visit[i][j] == false) {
						visitBfs(i,j);
						piece++;
					}
				}
			}
			if(piece >= 2) {
				System.out.println(answer);
				break;
			}
			if(flag == false) {
				System.out.println(0);
				break;
			}
			piece = 0;
		}
	}
	private static void visitBfs(int x, int y) {
		Queue<Ice> q = new LinkedList<>();
		q.add(new Ice(x,y));
		visit[x][y] = true;
		while(!q.isEmpty()) {
			Ice temp = q.poll();
			for(int i=0;i<4;i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx >= 0 && ny >= 0 && nx <= N && ny <= M) {
					if(visit[nx][ny] == false && arr[nx][ny] != 0) {
						q.add(new Ice(nx,ny));
						visit[nx][ny] = true;
					}
				}
			}
		}
	}
	private static void bfs(int x, int y) {
		int cnt = 0;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx <= N && ny <= M) {
				if(arr[nx][ny] == 0) {
					cnt++;
				}
			}
		}
		temp[x][y] = cnt;
	}
}
