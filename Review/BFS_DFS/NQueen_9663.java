package BFS_DFS;

import java.util.Scanner;

public class NQueen_9663 {
	static int N , ans = 0;
	static int[] col;	//각 배열의 값은 해당 인덱스번째 컬럼에 몇번째 로우에 퀸이 있는지를 의미
	public static void main(String[] args) {
		input();
		dfs(1);
		System.out.println(ans);
	}

	private static void dfs(int row) {
		if(row == N+1) {
			//행이 여기까지 왔다는건 모든 경우를 돌았다는것
			ans++;
		}
		else {
			for(int c=1;c<=N;c++) {
				boolean isVaild = true;
				//놓을 수 있는 자리인지 판별
				for(int i=1;i<=row-1;i++) {
					if(attackable(row,c,i,col[i])) {
						isVaild = false; 	//공격가능하면 유효하지 않다
						break;
					}
				}
				if(isVaild) {
					col[row] = c;
					dfs(row+1);
					col[row] = 0;
				}
			}
		}
	}

	private static boolean attackable(int x1, int y1, int x2, int y2) {
		if(y1==y2) return true;
		if(x1+y1 == x2+y2) return true;
		if(x1-y1 == x2-y2) return true;
		return false;
	}
b 
	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
	}
}
