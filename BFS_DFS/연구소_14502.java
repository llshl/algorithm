package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus{
	int x;
	int y;
	public Virus(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class 연구소_14502 {
	static int N, M;
	static int[][] arr;
	static int count = 0;
	static int answer = 0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//벽세우기
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {
					block(i,j);
				}
			}
		}
		System.out.println(answer);
	}
	
	private static void block(int x, int y) {
		arr[x][y] = 1;
		count++;
		if(count == 3) {
			//벽 3개 됐으면 bfs
			countSafeArea(bfs());
			arr[x][y] = 0;
			count--;
			return;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {
					block(i,j);
				}
			}
		}
		arr[x][y] = 0;
		count--;
	}

	private static void countSafeArea(int[][] copyArr) {
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyArr[i][j] == 0) {
					cnt++;	
				}
			}
		}
		answer = Math.max(cnt, answer);
	}

	private static int[][] bfs() {
		Queue<Virus> q = new LinkedList<>();
		
		int[][] copyArr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copyArr[i][j] = arr[i][j];
				if(arr[i][j] == 2) {
					q.add(new Virus(i,j));;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Virus temp = q.poll();
			for(int i=0;i<4;i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(inBound(nx,ny)) {
					if(copyArr[nx][ny] == 0) {
						copyArr[nx][ny] = 2;
						q.add(new Virus(nx,ny));
					}
				}
			}
		}
		return copyArr;
	}

	private static boolean inBound(int nx, int ny) {
		if(nx>=0&&ny>=0&&nx<N&&ny<M) return true;
		return false;
	}

}
