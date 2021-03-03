package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Bri{
	int x;
	int y;
	int stage;
	public Bri(int x, int y, int stage) {
		super();
		this.x = x;
		this.y = y;
		this.stage = stage;
	}
}

public class main2146 {

	public static int N;
	public static int piece = 1;
	public static int[][] arr; 
	public static boolean[][] visit;
	public static boolean[][] nearOne;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		nearOne = new boolean[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		NearBy();
		piece = 1;
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				if(nearOne[i][j] == true) {
//					System.out.print(1+" ");
//				}
//				else {
//					System.out.print(0+" ");
//				}
//			}
//			System.out.println("");
//		}
		int ans = 99999;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(nearOne[i][j] == true) {
					int temp = bfs(i,j);
					ans = Math.min(ans,temp);
				}
			}
		}
		System.out.println(ans);
	}
	private static int bfs(int x, int y) {
		Queue<Bri> q = new LinkedList<>();
		boolean[][] visit2 = new boolean[N][N];
		q.add(new Bri(x,y,0));
		visit2[x][y] = true;
		while(!q.isEmpty()) {
			Bri temp = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if(arr[nx][ny] != 0 && arr[nx][ny] != arr[x][y]) {
						//중단조건
						return temp.stage;
					}
					if(arr[nx][ny] == 0 && visit2[nx][ny] == false) {
						q.add(new Bri(nx,ny,temp.stage+1)); 
						visit2[nx][ny] = true;
					}
				}
			}
		}
		return -1;
		
	}
	private static void NearBy() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] != 0) {
					isNear(i,j);
					if(visit[i][j] == false) {
						firstBfs(i,j);
						piece++;
					}
				}
			}
		}
	}
	private static void firstBfs(int x, int y) {
		Queue<Bri> q = new LinkedList<>();
		//boolean[][] visit = new boolean[N][N];
		q.add(new Bri(x,y,0));
		visit[x][y] = true;
		arr[x][y] = piece;
		
		while(!q.isEmpty()) {
			Bri temp = q.poll();
			for(int i=0;i<4;i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if(arr[nx][ny] == 1 && visit[nx][ny] == false) {
						q.add(new Bri(nx,ny,temp.stage+1)); 
						visit[nx][ny] = true;
						arr[nx][ny] = piece;
					}
				}
			}
		}
	}
	private static void isNear(int x, int y) {
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(arr[nx][ny] == 0) {
					nearOne[x][y] = true;
				}
			}
		}
	}
}
