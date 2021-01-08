package BFS_DFS;

import java.util.Scanner;

public class main2606Re {
	public static int N;	//컴퓨터수
	public static int M;	//연결쌍수
	public static int cnt=0;
	public static int[][] arr;
	public static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][N+1];	//번호 그대로 사용하기위해 N+1까지 번위로 하고 0인덱스는 사용x
		visited = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			int tempX = sc.nextInt();
			int tempY = sc.nextInt();
			arr[tempX][tempY] = arr[tempY][tempX] = 1;	//간선연결
	
		}
		
		dfs(1);
		System.out.println(cnt-1);
		
	}
	private static void dfs(int index) {
		if(visited[index] == true) {	//방문했으면
			return;
		}
		cnt++;
		visited[index] = true;	//방문처리
		for(int i=1;i<N+1;i++) {
			if(arr[index][i]==1) {
				dfs(i);
			}
		}
	}
}
