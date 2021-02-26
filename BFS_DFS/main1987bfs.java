package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main1987bfs {

	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static char[][] arr;
	public static int R,C,answer=0,max=0;
	public static boolean[] visit = new boolean[26+1];	//A는 65, -64를하면 A가 1된다
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[21][21];
		for(int i=0;i<R;i++) {
			String temp = br.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		visit[(int)arr[0][0]-64] = true;
		dfs(0,0,1);
		System.out.println(max);
	}
	
	private static void dfs(int x, int y, int cnt) {
		if(max < cnt) {
			max = cnt;
		}
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
				if(visit[(int)arr[nx][ny]-64] == false) {
					visit[(int)arr[nx][ny]-64] = true;
					dfs(nx,ny,cnt+1);
					visit[(int)arr[nx][ny]-64] = false;
				}
			}
		}
	}
}
