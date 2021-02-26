package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main11725dfs {

	public static int[] answer;
	public static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] visit = new boolean[N+1];
		answer = new int[N+1];
		
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N+1;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		visit[0] = true;
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		bfs(visit,1);
		for(int i=2;i<answer.length;i++) {
			System.out.println(answer[i]);			
		}
	}

	private static void bfs(boolean[] visit, int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visit[x] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=0;i<graph.get(temp).size();i++) {
				if(visit[graph.get(temp).get(i)] == false) {
					visit[graph.get(temp).get(i)] = true;
					q.add(graph.get(temp).get(i));
					answer[graph.get(temp).get(i)] = temp;
				}
			}
		}
	}
}
