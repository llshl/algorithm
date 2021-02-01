package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node6 implements Comparable<Node6>{
	private int x;
	private int y;
	private int distance;
	private int drill;	//벽 부순 횟수
	
	public Node6(int x, int y, int distance, int drill) {
		this.x = x;
		this.y = y;
		this.distance = distance;
		this.drill = drill;
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
	public int getDrill() {
		return drill;
	}
	public void setDrill(int drill) {
		this.drill = drill;
	}

	@Override
	public int compareTo(Node6 other) {
		if(this.drill < other.drill) {
			return -1;
		}
		return 1;
	}
	
}

public class main1261 {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int[][] arr;
	public static boolean[][] visit;
	public static int N,M;
	public static int INF = (int)1e9;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String[] temp = br.readLine().split("");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		int ans = dijkstra();
		System.out.println(ans);
	}
	private static int dijkstra() {
		PriorityQueue<Node6> pq = new PriorityQueue<>();
		visit[0][0] = true;
		pq.offer(new Node6(0,0,0,0));	//x,y,distance,drill
		while(!pq.isEmpty()) {
			Node6 node = pq.poll();
			int x = node.getX();
			int y = node.getY();
			int dist = node.getDistance();
			int drill = node.getDrill();
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx == N-1 && ny == M-1) {
					return drill;
				}
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if(visit[nx][ny] == false) {	//방문 안한경우
					if(arr[nx][ny] == 0) {		//길일경우
						visit[nx][ny] = true;
						pq.offer(new Node6(nx,ny,dist+1,drill)); 	//거리만 1 늘리고 나머지는 그래로인채 큐에 넣는다
					}
					else {	//벽일경우
						visit[nx][ny] = true;
						pq.offer(new Node6(nx,ny,dist+1,drill+1)); 	//드릴값도 1 올려준다
					}
				}
			}
		}
		return 0;
	}
}

