package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node9{
	private int x;
	private int y;
	public Node9(int x, int y){
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

public class main7562 {
	public static int I;	//체스판 한변길이
	public static int[][] arr;
//	public static Queue<Node9> q;
	
	public static int[] dx = {-2,-1,1,2,2,1,-1,-2};
	public static int[] dy = {-1,-2,-2,-1,1,2,2,1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int k=0;k<T;k++) {
			I = sc.nextInt();
			int tempX = sc.nextInt();
			int tempY = sc.nextInt();
			int targetX = sc.nextInt();
			int targetY = sc.nextInt();
			arr = new int[I][I];
			arr[tempX][tempY] = 1;
			arr[targetX][targetY] = -1;
			
			
			bfs(tempX,tempY);
			
			int max=0;
			for(int i=0;i<I;i++) {
				for(int j=0;j<I;j++) {
					if(arr[i][j] >= max) {
						max = arr[i][j];
					}
				}
			}
			System.out.println(max-1);
		}
	}

	private static void bfs(int x, int y) {
		Queue<Node9> q = new LinkedList<>();
		q.add(new Node9(x,y));
		while(!q.isEmpty()) {
			Node9 node = q.poll();
			x = node.getX();
			y = node.getY();
			for(int i =0;i<8;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= I || ny >= I) {
					continue;
				}
				if(arr[nx][ny] == -1) {
					arr[nx][ny] = arr[x][y] + 1;
					return;
				}
				if(arr[nx][ny] == 0) {
					arr[nx][ny] = arr[x][y] + 1;
					q.add(new Node9(nx,ny));
				}
			}
		}
	}
}
