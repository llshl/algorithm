package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Alph{
	int x;
	int y;
	int count;
	ArrayList<Character> list;
	
	public Alph(int x, int y, int count, ArrayList<Character> list) {
		super();
		this.x = x;
		this.y = y;
		this.count = count;
		this.list = list;
	}
}

public class ¾ËÆÄºª_1987 {
	static int R, C;
	static int max = 0;
	static char[][] arr;
	static boolean[] visit = new boolean[26];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for(int i=0;i<R;i++) {
			String temp = br.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		visit[arr[0][0]-65] = true;
		dfs(0,0,0);
		
		System.out.println(max+1);
	}
	
	private static void dfs(int x, int y, int count) {
		max = Math.max(max, count);
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(inBound(nx,ny)) {
				if(!visit[arr[nx][ny]-65]) {
					visit[arr[nx][ny]-65] = true;
					dfs(nx,ny,count+1);
					visit[arr[nx][ny]-65] = false;
				}
			}
		}
	}

	private static boolean inBound(int nx, int ny) {
		if(nx>=0&&ny>=0&&nx<R&&ny<C) return true;
		return false;
	}
}