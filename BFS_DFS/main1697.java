package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class main1697 {
	static int N;
	static int K;
	static int[] visited = new int[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		if(N==K) {
			System.out.println(0);
		}
		else {
			bfs(N);
		}
	}
	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		visited[num] = 1;
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int i=0;i<3;i++) {
				int next;	//다음 이동할 칸
				if(i==0) {
					next = temp + 1;
				}
				else if(i==1) {
					next = temp - 1;
				}
				else {
					next = temp * 2;
				}
				
				if(next == K) {	//찾으면 방문회수 반환
					System.out.println(visited[temp]);
					return;
				}
				//범위조건 다음에 방문조건을 해야한다.
				if(next >= 0 && next < visited.length && visited[next] == 0) {
					q.add(next);
					visited[next] = visited[temp] + 1;	//이동횟수 +1
				}
			}
		}	
	}
}