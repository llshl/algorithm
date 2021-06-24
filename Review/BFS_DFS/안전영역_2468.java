package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Safe{
	int x;
	int y;
	public Safe(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class 안전영역_2468 {

	static int N, max = 0, rain = 0;
	static int[][] arr;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				rain = Math.max(rain, arr[i][j]);
			}
		}
		
		for(int i=1;i<rain;i++) {
			bfs(i);
		}
		System.out.println(max); 
	}
	
	private static void bfs(int depth) {
		Queue<Safe> q = new LinkedList<>();
		boolean[][] visit = new boolean[N+1][N+1];
		int tempmax = 0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(!visit[i][j] && arr[i][j] > depth) {
					q.add(new Safe(i,j));
					visit[i][j] = true;
					tempmax++;
					
					while(!q.isEmpty()) {
						Safe temp = q.poll();
						for(int t=0;t<4;t++) {
							int nx = temp.x + dx[t];
							int ny = temp.y + dy[t];
							if(inBound(nx,ny) && arr[nx][ny] > depth) {
								if(!visit[nx][ny]) {
									visit[nx][ny] = true;
									q.add(new Safe(nx,ny)); 
								}
							}
						}
					}
					
				}
				max = Math.max(tempmax, max);
			}
		}
	}

	private static boolean inBound(int nx, int ny) {
		if(nx>=1&&ny>=1&&nx<=N&&ny<=N){
			return true;
		}
		return false;
	}
}
