package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class main2644 {
	public static int n;	//전체사람수
	public static int a,b;	//두사람간의 촌수
	public static int m;	//관계수
	public static int ans;
	public static int cnt=0;
	public static int[] chon;
	public static boolean[] visited;
	public static int[][] arr = new int[101][101]; 	//가족관계배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//사람수
		a = sc.nextInt();
		b = sc.nextInt();
		m = sc.nextInt();	//관계수
		chon = new int[n+1];
		visited = new boolean[n+1];
		for(int i=1;i<m+1;i++) {
			int tempX = sc.nextInt();
			int tempY = sc.nextInt();
			arr[tempX][tempY] = arr[tempY][tempX] = 1;	//간선연결
		}
		//arr[a][b] = arr[b][a] = 5;
		bfs(a);
		System.out.println(ans);
		

	}
	private static void bfs(int index) {
		Queue<Integer> q = new LinkedList<>();
		chon[index] = 0;	//자신과 0촌인데 일단 방문처리때메 1로함 답에서 -1하자
		q.add(index);
		while(!q.isEmpty()) {
			index = q.poll();
			if(visited[index] == false) {	//방문안한노드라면
				visited[index] = true;
				for(int i=1;i<n+1;i++) {		//1~9(n사람수)
					if(arr[index][i] == 1 && visited[i] == false) {
						q.add(i);
						chon[i] = chon[index] + 1; //1촌 상승
					}
					if(index == b){		//이 순간이 목표노드에 다다랐을때
						ans = chon[index];
						return;
					}
				}
			}
		}
		ans = -1;
	}
}
