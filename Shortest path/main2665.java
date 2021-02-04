package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Node12 implements Comparable<Node12>{
	private int x;
	private int y;
	private int drill;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDrill() {
		return drill;
	}

	public Node12(int x, int y, int drill) {
		super();
		this.x = x;
		this.y = y;
		this.drill = drill;
	}
	@Override
	public int compareTo(Node12 other) {
		if(this.drill < other.drill) {
			return -1;
		}
		return 1;
	}
}


public class main2665 {
	public static int n;
	public static boolean[][] visit;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		visit = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			String[] temp = br.readLine().split("");  
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		System.out.println(solution(arr));
	}

	private static int solution(int[][] arr) {
		PriorityQueue<Node12> pq = new PriorityQueue<Node12>();
		visit[0][0] = true;
		pq.offer(new Node12(0,0,0));	//x,y,drill
		while(!pq.isEmpty()) {
			Node12 node = pq.poll();
			int x = node.getX();
			int y = node.getY();
			int drill = node.getDrill();
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx == n-1 && ny == n-1) {
					return drill;
				}
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if(visit[nx][ny] == false) {
						visit[nx][ny] = true;
						if(arr[nx][ny] == 1) {	//갈수있다면
							pq.offer(new Node12(nx,ny,drill));
						}
						else {	//갈수없다면
							pq.offer(new Node12(nx,ny,drill+1)); //드릴횟수하나 추가해서 간다
						}
					}
				}
			}
		}
		return -1;
	}
}

