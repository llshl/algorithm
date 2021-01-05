package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
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
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class main2178 {
	public static int N, M;
	public static int[][] arr = new int[101][101];
	public static int[] dx = {-1,1,0,0};	//»óÇÏÁÂ¿ì
	public static int[] dy = {0,0,-1,1};	//»óÇÏÁÂ¿ì
			
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i=0;i<N;i++) {
			String temp = "";
			temp = sc.next();
			for(int j=0;j<M;j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}
		System.out.println(bfs(0,0));
	}

	private static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x,y));
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.getX();
			y = node.getY();
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if(arr[nx][ny] == 0) {
					continue;
				}
				if(arr[nx][ny] == 1) {
					arr[nx][ny] = arr[x][y]+1; 
					q.offer(new Node(nx,ny));
				}
			}
		}
		return arr[N-1][M-1];
	}
}
