package BFS_DFS;

import java.util.Scanner;

public class N°úM4 {
	static int N,M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		input();
		dfs(0);
		System.out.println(sb.toString());
	}

	private static void dfs(int depth) {
		if(depth == M) {
			for(int i=0;i<M;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		else {
			int start;
			if(depth==0) {
				start = 1;
			}else {
				start = arr[depth-1];
			}
			for(int i=start;i<N+1;i++) {
				arr[depth] = i;
				dfs(depth+1);
			}
		}
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
	}

}
