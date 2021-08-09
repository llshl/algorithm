package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato{
	int z;
	int x;
	int y;
	int day;
	public Tomato(int z, int x, int y, int day) {
		super();
		this.z = z;
		this.x = x;
		this.y = y;
		this.day = day;
	}
}

public class 토마토_BFS_7569 {
	static int M,N,H;
	static int[][][] arr;
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};	//상하 좌우 아래위
	static Queue<Tomato> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][N][M];
		boolean alreadyFinished = true;
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int k=0;k<M;k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if(arr[i][j][k] == 0) alreadyFinished = false;
				}
			}
		}
		if(alreadyFinished) {
			System.out.println("0");
			return;
		}
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(arr[i][j][k] == 1) {
						q.add(new Tomato(i,j,k,0));
					}
				}
			}
		}
		bfs();
		
		int max = 0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(arr[i][j][k] == 0) {
						System.out.println("-1");
						return;
					}
					else {
						max = Math.max(max, arr[i][j][k]);
					}
				}
			}
		}
		System.out.println(max);
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			Tomato temp = q.poll();
			for(int i=0;i<6;i++) {
				int nz = temp.z + dz[i];
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(inBound(nz,nx,ny)) {
					if(arr[nz][nx][ny] == 0) {
						arr[nz][nx][ny] = temp.day + 1;
						q.add(new Tomato(nz,nx,ny,temp.day+1));
					}
				}
			}
		}
	}

	private static boolean inBound(int nz, int nx, int ny) {
		if(nz>=0&&nx>=0&&ny>=0&&nz<H&&nx<N&&ny<M) return true;
		return false;
	}
}
