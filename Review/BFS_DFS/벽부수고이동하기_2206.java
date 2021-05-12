package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Crash{
	int x;
	int y;
	int drill;
	int move;
	public Crash(int x, int y, int drill, int move) {
		super();
		this.x = x;
		this.y = y;
		this.drill = drill;
		this.move = move;
	}
}

public class 벽부수고이동하기_2206 {
	public static int N, M;
	public static int[][] arr;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			String[] temp = br.readLine().split("");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		if(N == 1 && M == 1) {
			System.out.println(1);
			return;
		}
		System.out.println(bfs());
	}
	private static int bfs() {
		Queue<Crash> q = new LinkedList<>();
		q.add(new Crash(0,0,0,1));
		int[][] visit = new int[N][M];	//3차 boolean배열로 해도된다(드릴 횟수가 0,1뿐이니까)
		for(int i=0;i<N;i++) {
			Arrays.fill(visit[i], 2);
		}
		visit[0][0] = 0;	//드릴의 사용횟수로 방문처리
		
		while(!q.isEmpty()) {
			Crash temp = q.poll();
			if(temp.x==N-1 && temp.y==M-1) {
				return temp.move;
			}
			for(int i=0;i<4;i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(inBound(nx,ny)) {
					if(visit[nx][ny] > temp.drill) {
						if(arr[nx][ny] == 0) {
							visit[nx][ny] = temp.drill;
							q.add(new Crash(nx,ny,temp.drill,temp.move+1));
						}
						else if(arr[nx][ny] == 1 && temp.drill == 0) {
							visit[nx][ny] = temp.drill+1;
							q.add(new Crash(nx,ny,temp.drill+1,temp.move+1));
						}
					}
				}
			}
		}
		return -1;
	}
	private static boolean inBound(int nx, int ny) {
		if(nx>=0 && ny>=0 && nx<N && ny<M) {
			return true;
		}
		return false;
	}
}

