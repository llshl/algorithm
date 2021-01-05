package BFS_DFS;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node1{
	private int x;
	private int y;
	public Node1(int x, int y){
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


public class main2583 {
	public static int N;
	public static int M;
	public static int K;
	public static int area = 0;
	public static int[][] arr;
	public static int[] dx = {-1,1,0,0};//»óÇÏÁÂ¿ì
	public static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][M];
		for(int i=0;i<K;i++){
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for(int j=y1;j<y2;j++) {
				for(int k=x1;k<x2;k++) {
					arr[j][k] = 1;
				}
			}
		}
		int cnt=0;
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] != 1) {
					cnt++;
					list.add(bfs(i,j));
				}
			}
		}
		Collections.sort(list);
		System.out.println(cnt);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	private static int bfs(int x, int y) {
		Queue<Node1> q = new LinkedList<>();
		q.offer(new Node1(x,y));
		int sum=1;
		arr[x][y] = 1;
		while(!q.isEmpty()) {
			Node1 node = q.poll();
			x = node.getX();
			y = node.getY();
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=M || (arr[nx][ny] == 1)) {
					continue;
				}
				else if(arr[nx][ny] == 0) {
					arr[nx][ny] =  1;
					q.offer(new Node1(nx,ny));
					sum++;
				}
			}
		}
		return sum;
	}
}
