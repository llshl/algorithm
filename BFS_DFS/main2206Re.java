package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Node13{
	private int x;
	private int y;
	private int drill;
	private int move;
	public Node13(int x, int y, int drill, int move) {
		this.x = x;
		this.y = y;
		this.drill = drill;
		this.move = move;
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
	public int getDrill() {
		return drill;
	}
	public void setDrill(int drill) {
		this.drill = drill;
	}
	public int getMove() {
		return move;
	}
	public void setMove(int move) {
		this.move = move;
	}
	
}

public class main2206Re {
	public static int N;
	public static int M;
	public static int ans;
	public static int[][] arr;
	public static int[][] visited;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		if(N == 1 && M == 1) {
			System.out.println(1);
			return;
		}
		arr = new int[N][M];
		visited = new int[N][M];
		for(int i=0;i<N;i++) {
			temp = br.readLine().split("");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
				visited[i][j] = 2;
			}
		}
		
		bfs(0,0);
		if(arr[N-1][M-1]!=5) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
		
	}
	private static void bfs(int x, int y) {
		Queue<Node13> q =new LinkedList<>();
		q.add(new Node13(x,y,0,1));	//move는 1부터 시작이다
		while(!q.isEmpty()) {		
			Node13 node = q.poll();
			x = node.getX();
			y = node.getY();
			int drill = node.getDrill();
			int move = node.getMove();
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if(nx == N-1 && ny == M-1) {
					arr[nx][ny] = 5;
					ans = move+1;
					return;
				}
				if(visited[nx][ny] > drill) {
					if(arr[nx][ny] == 1) {
						if(drill == 0) {
							visited[nx][ny] = drill + 1;
							q.add(new Node13(nx,ny,1,move+1));
						}
					}
					else if(arr[nx][ny] == 0){	//길이라면
						visited[nx][ny] = drill;
						q.add(new Node13(nx,ny,drill,move+1));
					}
				}
			}
		}
	}

}
