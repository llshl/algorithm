package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node5{
	private int x;
	private int y;
	
	public Node5(int x, int y) {
		this.x = x;
		this.y = y;
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
	
}


public class main2178Re {
	public static int N;
	public static int M;
	public static int[][] arr;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {-0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			String temp = "";
			temp = sc.next();
			for(int j=0;j<M;j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}
		bfs(0,0);
		System.out.println(arr[N-1][M-1]);
	}
	private static void bfs(int x, int y) {
		Queue<Node5> q = new LinkedList<>();
		q.add(new Node5(x,y));
		
		while(!q.isEmpty()) {
			Node5 node = q.poll();
			x = node.getX();
			y = node.getY();
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {	//하나라도 범위 벗어나면
					continue;
				}
				if(arr[nx][ny] == 0) {	//벽이면 
					continue;
				}
				if(arr[nx][ny] == 1) {
					arr[nx][ny] = arr[x][y] + 1;
					q.add(new Node5(nx,ny));
				}
			}
		}
	}
}
