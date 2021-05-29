package BFS_DFS;

import java.util.Scanner;

public class N°úM2 {
	static int N,M;
	static int[] arr;
	static boolean[] visit;
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
			if(depth==0) start = 1;
			else start = arr[depth-1];
			for(int i=start;i<N+1;i++) {
				if(!visit[i]) {
					visit[i] = true;
					arr[depth] = i;
					dfs(depth+1);
					visit[i] = false;
				}
			}
		}
		
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		visit = new boolean[N+1];
	}

}
