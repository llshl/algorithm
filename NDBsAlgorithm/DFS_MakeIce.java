package NDBsAlgorithm;

import java.util.Scanner;

public class DFS_MakeIce {
	public static int[][] map = new int[1000][1000];
	public static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i=0;i<N;i++) {
			String temp = sc.next();
			for(int j=0;j<M;j++) {
				map[i][j] = temp.charAt(j) - '0';	//map은 int형이므로 char형에서 '0'을빼서 형변환
			}
		}
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				boolean flag = dfs(i,j);
				if(flag == true) {
					cnt++;
					flag = false;
				}
			}
		}
		System.out.println(cnt);
	}

	private static boolean dfs(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) {	//좌표가 범위를 벗어날경우
			return false;
		}
		else if(map[x][y] == 0) {
			map[x][y] = 1;
			dfs(x+1,y);
			dfs(x-1,y);
			dfs(x,y+1);
			dfs(x,y-1);
			return true;
		}
		return false;
	}
}
