package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main1068 {

	public static int delete, start ,N;
	public static int answer = 0;
	public static boolean flag = true;
	public static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N];
		for(int i=0;i<N;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		start = -1;
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp != -1) {
				graph[temp].add(i);
			}
			else {
				start = i;
			}
		}
		delete = Integer.parseInt(br.readLine());
		deleteNode();
		
		if(start != delete) {
			dfs(start);
			System.out.println(answer);
		}
		else {
			System.out.println(0);
		}
	}

	private static void deleteNode() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<graph[i].size();j++) {
				if(graph[i].get(j) == delete) {
					graph[i].remove(j);
				}
			}
		}
	}

	private static void dfs(int index) {
		if(graph[index].size() == 0) {
			answer++;
			return;
		}
		for(int i=0;i<graph[index].size();i++) {
			if(graph[index].get(i) == delete && graph[index].size() == 1) {
				answer++;
				return;
			}
			else if(graph[index].get(i) != delete && graph[index].get(i) < N){
				dfs(graph[index].get(i));
			}
		}
	}
}
