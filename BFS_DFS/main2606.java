package BFS_DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class main2606 {
	public static int N;
	public static int M;
	public static int cnt = 0;;
	public static int[][] arr;
	public static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0;i<M;i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			arr[num1][num2] = arr[num2][num1] = 1;
		}
		dfs(1);
		System.out.println(cnt);
	}
	private static void dfs(int x) {
		visited[x] = true;
		for(int i=1;i<N+1;i++) {
			if(!visited[i] && arr[x][i]==1) {
				cnt++;
				dfs(i);
			}
		}
	}
}
