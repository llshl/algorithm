package BFS_DFS;

import java.util.Scanner;

public class main14502 {
	public static int N;
	public static int M;
	public static int[][] arr;
	public static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0;i<M;i++) {
			int tempX = sc.nextInt();
			int tempY = sc.nextInt();
			arr[tempY][tempX] = arr[tempX][tempY] = 1;	//간선연결
		}
		
		int cnt = 0;
		for(int i=1;i<N+1;i++) {
			if(visited[i] == false) {
				cnt++;
				dfs(i);
			}
		}
		System.out.println(cnt);
	}
	private static void dfs(int index) {
		if(visited[index]==true) {
			return;
		}
		else {
			visited[index] = true;
			for(int i=1;i<N+1;i++) {
				if(arr[index][i] == 1) {
					dfs(i);
				}
			}
		}
	}
}
