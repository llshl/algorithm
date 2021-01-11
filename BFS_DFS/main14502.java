package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Node14{
	private int x;
	private int y;
	public Node14(int x, int y){
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

public class main14502 {
	public static int N;
	public static int M;
	public static int ans=-1;
	public static int[][] arr;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		//1.dfs로 벽 3개 세우는 경우 찾기(벽을 세우고 dfs로 2개 세우기)
		//2.세운 상태에서 bfs로 바이러스 돌리기
		//3.확인메서드로 안전영역 개수세기
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {	//벽을 세울수 있는곳이라면
					arr[i][j] = 1;		//벽을 세우고
					dfs(1);
					arr[i][j] = 0;	//dfs - bfs실행 후 다시 벽 없애주기
				}
			}
		}
		System.out.println(ans);
	}
	private static void dfs(int cnt) {	//cnt는 dfs 3번까지 해서 벽 3개를 만들면 bfs로 넘어가느 카운트, dfs최초 진입시 이미 1이다.
		if(cnt == 3) {	//벽 3개 만들었다면
			bfs();
			//cnt=0;
			return;	//main의 dfs포문으로 다시 나감
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {	//벽을 세울수 있는곳이라면
					arr[i][j] = 1;		//벽을 세우고
					dfs(cnt+1);
					arr[i][j] = 0;	//dfs - bfs실행 후 다시 벽 없애주기
				}
			}
		}
		
	}
	private static void bfs() {
		//벽 세운 배열을 깊은 복사를 통해서 하나 더만들고 그걸로 bfs돌려야함
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {		//map배열로 bfs
			for(int j=0;j<M;j++) {
				map[i][j] = arr[i][j];
			}
		}
		Queue<Node14> q = new LinkedList<>();
		for(int i=0;i<N;i++) {		//map배열로 bfs
			for(int j=0;j<M;j++) {
				if(map[i][j] == 2) {
					q.add(new Node14(i,j));	//바이러스의 위치를 일단 다 큐에 넣고
				}
			}
		}
		while(!q.isEmpty()) {
			Node14 node = q.poll();
			int x = node.getX();
			int y = node.getY();
			for(int k=0;k<4;k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				if(map[nx][ny] == 1) {	//벽이라면
					continue;
				}
				else {
					map[nx][ny] = 1;	//벽으로 해버려서 방문처리 어자피 최종적으로는 0인 부분 갯수만 알면되니까
					q.add(new Node14(nx,ny));
				}
			}
		}
		isAnswer(map);  //이 배열의 0의 개수가 몇개인지 파악하고 그 중에서 max값을 저장하여 반환		
	}
	private static void isAnswer(int[][] map) {
		int max = 0;
		for(int i=0;i<N;i++) {		
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) {
					max++;
				}
			}
		}
		if(ans <= max) {	//max값 갱신
			ans = max;
		}
	}
}
