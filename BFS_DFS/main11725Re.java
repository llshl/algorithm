package BFS_DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class main11725Re {
	public static int N;
	public static boolean[] visited;
	public static int[] ans;
	public static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new boolean[N+1];
		list = new ArrayList<>();
		ans = new int[N+1];
		for(int i=0;i<N;i++) {				  //0번부터 7번까지	//노드가 7개면 1~7번노드가 있으니 7번도 넣어줘야한다
			list.add(new ArrayList<Integer>());
		}
		for(int i=0;i<N-1;i++) {		//N-1번 수행
			int temp1 = sc.nextInt();
			int temp2 = sc.nextInt();
			list.get(temp2).add(temp1);
			list.get(temp1).add(temp2);
		}
		dfs(1);
		for(int i=1;i<ans.length;i++) {	//2부터인 이유는 0번인덱스에는 아무것도 없고(0번노드는 없고 1번노드부터 있으니까) 1번인덱스는 1번노드의 부모로 아무것도 없기에 안쓴다
			System.out.println(ans[i]);
		}
	}

	private static void dfs(int index) {
		visited[index] = true;
		for(int i : list.get(index)) {	
			if(visited[i] == false) {
				ans[i] = index;		//1번노드의 자식으로는 6,4인데 이렇게 되면 ans[6] = 1, ans[4] = 1이 된다 즉 6번의 부모는 1 4번의 부모는 1이라는 소리
				dfs(i);
			}
		}
	}
}
