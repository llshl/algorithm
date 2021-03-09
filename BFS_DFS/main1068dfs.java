package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main1068dfs {

	public static ArrayList<Integer>[] graph;
	public static boolean[] visit;
	public static int N = -999;
	public static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int head = -1;
		graph = new ArrayList[N];
		visit = new boolean[N];
		for(int i=0;i<N;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp != -1) {
				graph[temp].add(i);
			}
			else {
				head = i;
			}
		}
		int delete = Integer.parseInt(br.readLine());
		if(delete == 0) {
			System.out.println(0);
			return;
		}
		//삭제할 노드의 부모노드가 누구인지 찾기
		int deleteParent = -1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<graph[i].size();j++) {
				if(graph[i].get(j) == delete) {
					deleteParent = i;
				}
			}
		}
		for(int i=0;i<graph[deleteParent].size();i++) {
			if(graph[deleteParent].get(i) == delete) {
				graph[deleteParent].remove(i);
			}
		}
		deleteDfs(delete);
		visit = new boolean[N];
		dfs(head);
		if(graph[head].size() == 0) {
			System.out.println(1);
		}
		else {
			System.out.println(cnt);
		}
	}
	private static void dfs(int n) {
		visit[n] = true;	//굳이?
		for(int i=0;i<graph[n].size();i++) {			
			if(visit[graph[n].get(i)] == false) {
				visit[graph[n].get(i)] = true;
				dfs(graph[n].get(i));
				visit[graph[n].get(i)] = false;
			}
		}
		visit[n] = false;
		if(graph[n].size() == 0) {
			cnt++;
		}
	}
	private static void deleteDfs(int delete) {
		visit[delete] = true;
		for(int i=0;i<graph[delete].size();i++) {
			if(visit[graph[delete].get(i)] == false) {
				deleteDfs(graph[delete].get(i));
			}
		}
		graph[delete] = new ArrayList<Integer>();
	}
}
