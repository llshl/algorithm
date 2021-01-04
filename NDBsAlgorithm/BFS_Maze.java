package NDBsAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	private int x;
	private int y;
	public Node(int x, int y) {
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


public class BFS_Maze {
	public static int[][] map = new int[201][201];
	public static int[] dx = {-1,1,0,0};	//»óÇÏÁÂ¿ì
	public static int[] dy = {0,0,-1,1};
	public static int N;
	public static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i=0;i<N;i++) {
			String temp = sc.next();
			for(int j=0;j<M;j++) {
				map[i][j] = temp.charAt(j) - '0';
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
				if(nx<0 || ny<0 || nx>=N || ny>=M) {
					continue;
				}
				if(map[nx][ny] == 0) {
					continue;
				}
				if(map[nx][ny] == 1) {
					map[nx][ny] = map[x][y] + 1;
					q.offer(new Node(nx,ny));
				}
			}
		}
		
		return map[N-1][M-1];
		
	}

}
/*
5 6
101010
111111
000001
111111
111111
*/