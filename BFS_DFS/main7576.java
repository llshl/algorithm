package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node2{
	private int x;
	private int y;
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
	public Node2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class main7576 {
	public static int N;
	public static int M;
	public static int day = 0;
	public static int temp;
	public static int[][] arr;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static Queue<Node2> q = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		boolean flag = false;
		int cnt = 0;
		arr = new int[M][N];
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) {
					q.offer(new Node2(i,j));
				}
				else if(arr[i][j] == 0){
					flag = true;
				}
			}
		}
	
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] == 1) {
					bfs();	//1일때만 day늘려주는 연산인 bfs수행
				}
			}
		}
		int max= 0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
				else {
					max = Math.max(max, arr[i][j]);
				}
			}
		}
		System.out.println(max-1);
	}

		private static void bfs() {
		while(!q.isEmpty()) {
			Node2 node = q.poll();
			int x = node.getX();
			int y = node.getY();
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || ny<0 || nx>=M || ny>=N ) {
					continue;
				}
				else if(arr[nx][ny] != 0) {
					continue;
				}
				arr[nx][ny] = arr[x][y] + 1;
				q.offer(new Node2(nx,ny));
			}
		}
	}
}
