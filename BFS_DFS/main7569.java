package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node8{
	private int x;
	private int y;
	private int z;
	public Node8(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
}

public class main7569 {
	public static int N;	//유저수
	public static int M;	//관계 수 (간선 수)
	public static int H;	
	public static boolean flag = false;	
	public static int[][][] arr;
	public static int[] dx = {-1,1,0,0,0,0};	//상하좌우위아래
	public static int[] dy = {0,0,-1,1,0,0};
	public static int[] dz = {0,0,0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		arr = new int[H][N][M];
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					arr[k][i][j] = sc.nextInt();
					if(arr[k][i][j] == 0) {	//안익은 토마토가 하나라도 들어왔다면
						flag = true;
					}
				}
			}
		}
		
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					System.out.print(arr[k][i][j]);
				}
				System.out.println("");
			}
			System.out.println("");
		}
		
		if(flag == false) {
			System.out.println(0);
			return;
		}
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[k][i][j] == 1) {
						bfs(k,i,j);
					}
				}
			}
		}
		
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					System.out.print(arr[k][i][j]);
				}
				System.out.println("");
			}
			System.out.println("");
		}
		
		
		int max = 0;
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[k][i][j] == 0) {
						System.out.println(-1);
						return;
					}
					if(max <= arr[k][i][j]) {
						max = arr[k][i][j];
					}
				}
			}
		}
		System.out.println(max);

	}
	private static void bfs(int z, int x, int y) {
		Queue<Node8> q = new LinkedList<>();
		q.add(new Node8(x,y,z));
		while(!q.isEmpty()) {
			Node8 node = q.poll();
			x = node.getX();
			y = node.getY();
			z = node.getZ();
			for(int i=0;i<6;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if(nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) {
					continue;
				}
				if(arr[nz][nx][ny] == -1) {
					continue;
				}
				if(arr[nz][nx][ny] == 0) {
					arr[nz][nx][ny] = arr[z][x][y] + 1;
					q.add(new Node8(ny,nx,nz));
				}
			}
		}
	}

}
