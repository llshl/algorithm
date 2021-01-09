package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node10{
	private int x;
	private int y;
	
	public Node10(int x, int y) {
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

public class main10026 {
	public static int N;
	public static char[][] arr;
	public static char[][] arr2;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		arr2 = new char[N][N];
		for(int i=0;i<N;i++) {
			String temp = sc.next();
			for(int j=0;j<N;j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		//arr2 = arr;	//색맹용 배열
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] == 'G') {
					arr2[i][j] = 'R';
				}
				else {
					arr2[i][j] = arr[i][j];
				}
			}
		}
		
		
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] != 'Z') {
					char target = arr[i][j];
					bfs(i,j,target);	
					cnt++;
				}
			}
		}
		int cnt2=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr2[i][j] != 'Z') {
					char target = arr2[i][j];
					bfs2(i,j,target);	
					cnt2++;
				}
			}
		}
	
		System.out.println(cnt);
		System.out.println(cnt2);

	}
	private static void bfs2(int x, int y, char target) {
		Queue<Node10> q = new LinkedList<>();
		q.add(new Node10(x,y));
		while(!q.isEmpty()) {
			Node10 node = q.poll();
			x = node.getX();	//영역 개수 세기. 색맹용은 R G를 같은걸로 세기
			y = node.getY();
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}
				if(arr2[nx][ny] == 'Z') {
					continue;
				}
				if(arr2[nx][ny] == target) {
					q.add(new Node10(nx,ny));
					arr2[nx][ny] = 'Z';
				}
			}
		}
	}
	
	private static void bfs(int x, int y, char target) {
		Queue<Node10> q = new LinkedList<>();
		q.add(new Node10(x,y));
		while(!q.isEmpty()) {
			Node10 node = q.poll();
			x = node.getX();	//영역 개수 세기. 색맹용은 R G를 같은걸로 세기
			y = node.getY();
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}
				if(arr[nx][ny] == 'Z') {
					continue;
				}
				if(arr[nx][ny] == target) {
					q.add(new Node10(nx,ny));
					arr[nx][ny] = 'Z';
				}
			}
		}
	}
}
