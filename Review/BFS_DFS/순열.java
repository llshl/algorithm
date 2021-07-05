package BFS_DFS;

import java.util.Scanner;

public class test순열 {
	
	static String str = "";
	static String answer = "";
	static boolean[] visit;
	static int n;
	static int r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		visit = new boolean[n];
		str  = "";
		char temp = 'a';
		for(int i=1;i<=n;i++) {
			str += temp;
			temp += 1;
		}
		
		for(int i=0;i<str.length();i++) {
			visit[i] = true;
			answer += str.charAt(i);
			dfs(i);
			//answer.substring(0, answer.length()-1);	//끝에 한글자 제거
			answer = "";
			visit[i] = false;
		}

	}

	private static void dfs(int index) {
		if(answer.length() == r) {
			System.out.println(answer);
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			if(!visit[i]) {
				visit[i] = true;
				answer += str.charAt(i);
				dfs(i);
				answer = answer.substring(0, answer.length()-1);	//끝에 한글자 제거
				visit[i] = false;
			}
		}
	}
}
