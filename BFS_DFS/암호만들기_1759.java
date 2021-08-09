package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기_1759 {
	static int L, C;
	static char[] arr;
	static String answer = "";
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		visit = new boolean[C];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<C;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		dfs(0);
	}
	
	private static void dfs(int index) {
		if(answer.length() == L) {
			if(isPossible()) {
				System.out.println(answer);
			}
			
			return;
		}
		for(int i=index;i<C;i++) {
			if(!visit[i]) {
				visit[i] = true;
				answer += arr[i];
				dfs(i);
				answer = answer.substring(0, answer.length()-1);
				visit[i] = false;
			}
		}
	}

	private static boolean isPossible() {
		int mo = 0;
		int ja = 0;
		for(int i=0;i<answer.length();i++) {
			char temp = answer.charAt(i); 
			if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
				mo++;
			}
			else {
				ja++;
			}
		}
		if(mo >= 1 && ja >= 2) return true;
		return false;
	}
}
