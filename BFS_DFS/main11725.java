package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main11725 {
	public static int N;
	public static int end;
	public static ArrayList<ArrayList<Integer>> tree;
	public static int[] ans;
	public static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		tree = new ArrayList<>();
		for(int i=0;i<N+1;i++) {
			tree.add(new ArrayList<>());	//N은 노드개수. n=7이면 노드가 7번노드까지 있으니 i<N+1까지해야 7번노드까지 나온다
		}
		ans = new int[N+1];
		
		for(int i=1;i<N;i++) {
			String[] temp = br.readLine().split(" ");
			tree.get(Integer.parseInt(temp[0])).add(Integer.parseInt(temp[1]));
			tree.get(Integer.parseInt(temp[1])).add(Integer.parseInt(temp[0]));
		}
		
		dfs(1);	//항상 1부터 탐색 시작
		
		for(int i=2;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
	private static void dfs(int index) {
		visited[index] = true;
		for(int i : tree.get(index)) {
			if(visited[i] == false) {	//4에 안가봤으면
				ans[i] = index;		//ans[4] = 그 부모인 index를 넣는다
				dfs(i);				//자식을 부모로 해서 다시 시작
			}
		}
	}
}
