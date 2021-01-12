package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Node15{
	private int x;
	private int y;
	
	public Node15(int x, int y) {
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


public class main14502Re {
	public static int N;
	public static int M;
	public static int ans=-1;
	public static int[][] arr;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {-0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			input = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		//1.dfs로 벽 3개 세우는 모든 경우 돌기
		//2.그 경우마다 bfs로 바이러스 퍼트리기
		//3.퍼트릴때마다 안전영역구하기
		for(int i=0;i<N;i++) {	//여기서 벽 한개를 세우고 dfs 들어가는 이유는 여기서 벽세우기를 시작해야 모든 지점에서 세워볼수 있다
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {	//벽을 세울 수 있으면
					arr[i][j] = 1;
					dfs(1);
					arr[i][j] = 0;	//다시 벽 지워줘야함
				}
			}
		}
		System.out.println(ans);
	}
	
	private static void dfs(int cnt) {
		if(cnt == 3) {	//벽이 3개가 됏다면 bfs수행
			bfs();
			return;
		}
		else {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j] == 0) {	//벽을 세울 수 있으면
						arr[i][j] = 1;
						dfs(cnt+1);
						arr[i][j] = 0;	//다시 벽 지워줘야함
					}
				}
			}
		}
		
	}
	private static void bfs() {
		//지금 arr에는 벽이 3개 세워져잇으므로 그 상태에서 바이러스를 돌려본다.
		Queue<Node15> q = new LinkedList<>();
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 2) {
					q.add(new Node15(i,j)); //바이러스 위치를 큐에 넣는다
				}
				map[i][j] = arr[i][j];	//벽 세워진 지도를 깊은 복사
			}
		}
		while(!q.isEmpty()) {
			Node15 node = q.poll();
			int x = node.getX();
			int y = node.getY();
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if(map[nx][ny] == 1) {
					continue;
				}
				else if(map[nx][ny] == 0){
					q.add(new Node15(nx,ny));
					map[nx][ny] = 1;	//방문처리를 1로한다.
				}
			}
		}
		isMax(map);	//안전영역의 최대를 구하는 함수
	}

	private static void isMax(int[][] map) {
		int count = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) {
					count++;
				}
			}
		}
		if(count >= ans) {
			ans = count;
		}
		count = 0;
	}
}



