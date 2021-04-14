package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main1987 {

	public static int R, C;
	public static int answer = 0;
	public static String[][] arr;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static boolean[] visit = new boolean[26];	//A = 65
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[R][C];
		for(int i=0;i<R;i++) {
			String[] temp = br.readLine().split("");
			for(int j=0;j<C;j++) {
				arr[i][j] = temp[j];
			}
		}
		visit[(int)(arr[0][0].charAt(0))-65] = true;
		dfs(0,0,1);
		System.out.println(answer);
	}
	private static void dfs(int x, int y, int cnt) {
		answer = Math.max(answer, cnt);
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(inBound(nx,ny)) {
				if(visit[(int)(arr[nx][ny].charAt(0))-65] == false) {
					visit[(int)(arr[nx][ny].charAt(0))-65] = true;
					dfs(nx,ny, cnt+1);
					visit[(int)(arr[nx][ny].charAt(0))-65] = false;
				}
			}
		}
	}
	private static boolean inBound(int nx, int ny) {
		if(nx>=0&&ny>=0&&nx<R&&ny<C) {
			return true;		
		}
		return false;
	}

}
