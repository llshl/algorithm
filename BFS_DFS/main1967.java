package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Nnode{
	int index;
	int weight;
	public Nnode(int index, int weight) {
		super();
		this.index = index;
		this.weight = weight;
	}
}

public class main1967 {

	public static int N;
	public static int far = 0;
	public static int farIndex = 0;
	public static ArrayList<Nnode>[] graph;
	public static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		visit = new boolean[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<Nnode>();
		}
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Nnode(b,c));
			graph[b].add(new Nnode(a,c));
		}
		for(int i=0;i<graph[1].size();i++) {
			visit[1] = true;
			dfs(graph[1].get(i).index,graph[1].get(i).weight);	//1번 노드에서 가장 먼 노드 찾기
			visit[1] = false;
		}
		far = 0;
		for(int i=0;i<graph[farIndex].size();i++) {
			visit[farIndex] = true;
			dfs(graph[farIndex].get(i).index,graph[farIndex].get(i).weight);	
			visit[farIndex] = false;
		}
		System.out.println(far);
	}
	private static int dfs(int x, int depth) { 
		visit[x] = true;
		for(int i=0;i<graph[x].size();i++) {
			int nextIndex = graph[x].get(i).index;
			if(visit[nextIndex] == false) {
				dfs(nextIndex, (graph[x].get(i).weight)+depth);
			}
		}
		if(depth > far) {
			far = depth;
			farIndex = x;
		}
		visit[x] = false;
		return depth;
	}
}
