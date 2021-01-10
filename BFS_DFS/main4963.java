package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node12{
	private int x;
	private int y;
	public Node12(int x, int y) {
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

public class main4963{
	public static int w=-1;
	public static int h=-1;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int cnt=0;
	public static int[] dx = {-1,1,0,0,-1,-1,1,1};
	public static int[] dy = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(w != 0 && h != 0) {
			String input = br.readLine();
			if(input.equals("0 0")) {
				return;
			}
			else {
				StringTokenizer st = new StringTokenizer(input);
				w =Integer.parseInt(st.nextToken());
				h =Integer.parseInt(st.nextToken());
				arr = new int[h][w];
				visited = new boolean[h][w];
				for(int i=0;i<h;i++) {
					st = new StringTokenizer(br.readLine());
					for(int j=0;j<w;j++) {
						arr[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				for(int i=0;i<h;i++) {
					for(int j=0;j<w;j++) {
						if(arr[i][j] == 1 && visited[i][j] == false) {
							cnt++;
							bfs(i,j);
						}
					}
				}
				System.out.println(cnt);
				cnt = 0;
			}
		}
	}
	private static void bfs(int x, int y) {
		Queue<Node12> q = new LinkedList<>();
		q.add(new Node12(x,y));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Node12 node = q.poll();
			x = node.getX();
			y = node.getY();
			for(int i=0;i<8;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0|| ny < 0 || nx >= h || ny >= w) {
					continue;
				}
				if(arr[nx][ny] == 0) {
					continue;
				}
				else if(visited[nx][ny] == false){
					visited[nx][ny] = true;
					q.add(new Node12(nx,ny));
				}
			}
		}
	}
}

