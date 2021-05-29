package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N°úM3 {

	public static int N,M;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		input();
		dfs(0);
		System.out.println(sb.toString());
	}

	private static void dfs(int depth) {
		if(depth == M) {
			for(int a : arr) {
				sb.append(a+" ");
			}
			sb.append("\n");
			return;
		}
		else {
			for(int i=1;i<N+1;i++) {
				arr[depth] = i;
				dfs(depth+1);
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
	}

}
