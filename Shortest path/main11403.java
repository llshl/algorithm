package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs
public class main11403 {

	public static int N;
	public static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	private static void bfs() { 
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			boolean[] visit = new boolean[N+1];
			q.offer(i);
			while(!q.isEmpty()) {
				int x = q.poll();
				for(int j=1;j<=N;j++) {
					if(arr[x][j] == 1 && visit[j] == false) {
						q.offer(j);
						visit[j] = true;
						arr[i][j] = 1;
					}
				}
			}
		}
	}
}

