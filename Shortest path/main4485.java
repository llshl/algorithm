package Shortest_Path;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node2 implements Comparable<Node2>{
	private int x;
	private int y;
	private int distance;
	
	public Node2(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
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

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(Node2 other) {
		if(this.distance < other.distance) {
			return -1;
		}
		return 1;	//자리바꿈
	}
}


public class main4485 {
	public static int N, ans;
	public static int[] dx = {-1,1,0,0};	//상하좌우
	public static int[] dy = {0,0,-1,1};
	public static int[][] arr;
	public static boolean[][] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int num = 1;
		while(true) {
			N = sc.nextInt();
			if(N==0) {
				break;
			}
			arr = new int[N][N];
			check = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			Dijkstra();
			System.out.println("Problem "+ num +": " + ans);
			ans = 0;
			num++;
		}
	}
	private static void Dijkstra() {
		PriorityQueue<Node2> pq = new PriorityQueue<>();
		pq.offer(new Node2(0,0,arr[0][0]));	//(0,0) 누적거리:arr[0][0]
		while(!pq.isEmpty()) {
			Node2 node = pq.poll();
			int x = node.getX();
			int y = node.getY();
			int dist = node.getDistance();
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if(check[nx][ny] == false) {
						check[nx][ny] = true;
						pq.offer(new Node2(nx,ny,dist+arr[nx][ny]));
						if(nx == N-1 && ny == N-1) {	//도달했다면
							ans = dist + arr[nx][ny];
							break;
						}
					}
				}
			}
		}
	}
}

