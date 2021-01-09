package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node7{
	private int x;
	private int y;
	public Node7(int x, int y){
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

public class main7576Re {
	public static int N;
	public static int M;
	public static int[][] arr;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static boolean flag = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Node7> q = new LinkedList<>();
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) {
					q.add(new Node7(i,j));
					flag = true;	//안익은 토마토가 들어오긴했다
				}
			}
		}
		
		if(flag == false) {
			System.out.println(0);
			return;
		}
		bfs(q);
		
		int max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(max <= arr[i][j]) {
					max = arr[i][j];
				}
				if(arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(max-1);
	}

	private static void bfs(Queue<Node7> q) {
		while(!q.isEmpty()) {
			Node7 node = q.poll();
			int x = node.getX();
			int y = node.getY();
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {	//하나라도 범위 벗어나면
					continue;
				}
				if(arr[nx][ny] == -1) {	//길이 아니라면
					continue;
				}
				if(arr[nx][ny] == 0) {	//길이라면
					arr[nx][ny] = arr[x][y]+1;
					q.add(new Node7(nx,ny));
				}
			}
		}
	}
}
