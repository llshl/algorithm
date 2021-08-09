package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ÃÌ¼ö°è»ê_2644 {
	static int N, a, b, M;
	static ArrayList<Integer>[] graph;
	static int answer = 0, count = 0;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		visit = new boolean[N+1]; 
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		dfs(a);
		System.out.println(answer-1);
	}
	
	private static void dfs(int now) {
		visit[now] = true;
		count++;
		if(now == b) {
			answer = count;
			return;
		}
		for(int next : graph[now]) {
			if(!visit[next]) {
				dfs(next);
			}
		}
		visit[now] = false;
		count--;
	}
}
