package BFS_DFS;

import java.util.Scanner;

public class NQueen_9663 {
	static int N , ans = 0;
	static int[] col;	//�� �迭�� ���� �ش� �ε�����° �÷��� ���° �ο쿡 ���� �ִ����� �ǹ�
	public static void main(String[] args) {
		input();
		dfs(1);
		System.out.println(ans);
	}

	private static void dfs(int row) {
		if(row == N+1) {
			//���� ������� �Դٴ°� ��� ��츦 ���Ҵٴ°�
			ans++;
		}
		else {
			for(int c=1;c<=N;c++) {
				boolean isVaild = true;
				//���� �� �ִ� �ڸ����� �Ǻ�
				for(int i=1;i<=row-1;i++) {
					if(attackable(row,c,i,col[i])) {
						isVaild = false; 	//���ݰ����ϸ� ��ȿ���� �ʴ�
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
