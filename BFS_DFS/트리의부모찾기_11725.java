package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ʈ���Ǻθ�ã��_11725 {
	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] visit;
	static int[] answer;
	static boolean flag = false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		visit = new boolean[N+1];
		answer = new int[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=1;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		dfs(1);
		for(int i=2;i<=N;i++) {
			System.out.println(answer[i]);
		}
	}
	
	private static void dfs(int now) {
		visit[now] = true;
		for(int nextNum : graph[now]) {
			if(!visit[nextNum]) {
				answer[nextNum] = now;
				dfs(nextNum);
			}
		}
		visit[now] = false;
	}
}
