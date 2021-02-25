package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main2667dfs {

	public static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int  N = Integer.parseInt(br.readLine());
		boolean[][] visit = new boolean[N][N];
		int[][] arr = new int[N][N];
		int danji = 0;
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j] = temp.charAt(j)-'0';
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] == 1 && visit[i][j] == false) {
					dfs(visit,arr,i,j);
					cnt++;
					danji++;
					list.add(cnt);
					cnt = 0;
				}
			}
		}
		int[] answer = new int[list.size()];
		int index = 0;
		for(int a : list) {
			answer[index] = a;
			index++;
		}
		Arrays.sort(answer);
		System.out.println(danji);
		for(int a : answer) {
			System.out.println(a);
		}
	}
	

	private static void dfs(boolean[][] visit, int[][] arr, int x, int y) { 
		visit[x][y] = true;
		
		if(x-1 >= 0 && arr[x-1][y] == 1 && visit[x-1][y] == false) {
			dfs(visit,arr,x-1,y);
			cnt++;
		}
		if(y-1 >= 0 && arr[x][y-1] == 1 && visit[x][y-1] == false) {
			dfs(visit,arr,x,y-1);
			cnt++;
		}
		if(x+1 < arr.length && arr[x+1][y] == 1 && visit[x+1][y] == false) {
			dfs(visit,arr,x+1,y);
			cnt++;
		}
		if(y+1 < arr.length && arr[x][y+1] == 1 && visit[x][y+1] == false) {
			dfs(visit,arr,x,y+1);
			cnt++;
		}
		else {
			return;
		}
	}
}
