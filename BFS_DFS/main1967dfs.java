package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Poi{
	int num;
	int weight;
	public Poi(int num, int weight) {
		super();
		this.num = num;
		this.weight = weight;
	}
}

public class main1967dfs {

	public static int N;
	public static int maxWeight = 0;
	public static int maxNode = 0;
	public static ArrayList<Poi>[] graph;
	public static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		visit = new boolean[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<Poi>();
		}
		for(int i=0;i<N-1;i++) {	//N-1번반복
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Poi(b,c)); 	//a -> b로 c만큼 가중치
			graph[b].add(new Poi(a,c));
		}
		
		for(int i=0;i<graph[1].size();i++) {
			//visit[1] = true;
			dfs(graph[1].get(i).num, graph[1].get(i).weight);
			//visit[1] = false;
		}
		maxWeight = 0;
		for(int i=0;i<graph[maxNode].size();i++) {
			//visit[maxNode] = true;
			dfs(graph[maxNode].get(i).num,graph[maxNode].get(i).weight);
			//visit[maxNode] = false;
		}
		System.out.println(maxWeight);
	}
	
	private static void dfs(int n, int weight) { 
		visit[n] = true;
		for(int i=0;i<graph[n].size();i++) {
			if(visit[graph[n].get(i).num] == false) {
				//visit[graph[n].get(i).num] = true;
				dfs(graph[n].get(i).num,weight+graph[n].get(i).weight);
				//visit[graph[n].get(i).num] = false;
			}
		}
		if(maxWeight < weight) {
			maxWeight = weight;
			maxNode = n;
		}
		visit[n] = false;
	}
}
