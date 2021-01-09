package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class main1697Re {
	public static int N;
	public static int K;
	public static int ans;
	public static int cnt=0;
	public static int[] arr = new int[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		if(N==K) {
			System.out.println(0);
		}else {
			bfs(N);
			System.out.println(ans);
		}
	}
	private static void bfs(int N) {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		arr[N] = 1;
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=0;i<3;i++) {
				int nx = x;
				if(i==0) {
					nx = nx - 1;
				}
				else if(i==1) {
					nx = nx + 1;
				}
				else {
					nx = nx * 2;
				}
				
				if(nx < 0 || nx >= 100001) {
					continue;
				}
				if(nx == K) {
					ans = arr[x];
					return;
				}
				else if(arr[nx] == 0) {
					arr[nx] = arr[x] + 1;
					q.add(nx);
				}
			}
		}
	}
}


