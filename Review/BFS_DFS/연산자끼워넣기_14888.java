package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기_14888 {
	static int N, max, min;
	static int[] arr, oper;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		dfs(1,arr[1]);
		System.out.println(max+"\n"+min);
	}

	private static void dfs(int depth, int value) {
		if(depth == N) {
			//한가지의 경우가 완성됐으므로 이 경우에 대한 값을 구해야함
			max = Math.max(value, max);
			min = Math.min(value, min);
			return;
		}
		else {
			for(int i=1;i<=4;i++) {
				if(oper[i] >= 1) {
					oper[i]--;
					//value = calc(value, i, arr[depth+1]);	//현재까지 값에 이번에 연산할 값을 더해줌
					dfs(depth+1, calc(value, i, arr[depth+1]));
					oper[i]++;
				}
			}
		}
	}

	private static int calc(int value, int oper, int num) {
		if(oper == 1) value += num;
		else if(oper == 2) value -= num;
		else if(oper == 3) value *= num;
		else value /= num;
		return value;
	}

	private static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		oper = new int[5];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=4;i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}

}
