package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main1325dfs {

	//public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<Integer>[] graph;
	public static boolean[] visit;
	public static int answer = 0;
	public static int[] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		graph = new ArrayList[N+1];
		ans = new int[N+1];
		for(int i=0;i<N+1;i++) {
			//graph.add(new ArrayList<Integer>());
			graph[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//graph.get(a).add(b);
			graph[a].add(b);
			//graph.get(b).add(a);
		}
		for(int i=1;i<N+1;i++) {
			dfs(i);
			visit = new boolean[N+1];
			//ans[i] = answer;
			//answer = 0;
		}
		int max = 0;
		for(int a : ans) {
			if(max < a) {
				max = a;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<ans.length;i++) {
			if(ans[i] == max) {
				sb.append(i+" ");
			}
		}
		System.out.println(sb.toString()); 
	}
	private static void dfs(int x) {
		//answer++;
		visit[x] = true;
//		for(int i=0;i<graph.get(x).size();i++) {
//			if(!visit[graph.get(x).get(i)]) {	//방문안햇다면
//				dfs(graph.get(x).get(i));
//				ans[graph.get(x).get(i)]++;
//			}
//		}
		for(int i=0;i<graph[x].size();i++) {
			if(!visit[graph[x].get(i)]) {	//방문안햇다면
				dfs(graph[x].get(i));
				ans[graph[x].get(i)]++;
			}
		}
	}
}
