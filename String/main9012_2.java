package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class main9012_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean ans = false; 
		String s;
		int cnt = 0;
		
		while(cnt != N) {
			ans = true;
			Stack<Character> st = new Stack<Character>();
			s = br.readLine();
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i) == '(') {
					st.push('(');
				}
				else {
					if(!st.isEmpty()) {	//비어있지 않다면, 즉 (가 들어있다면
						st.pop();
					}
					else {
						ans = false;
						break;
					}
				}
			}
			if(!st.isEmpty()) {	//for 문을 다 돌아도 스택에 무언가 남아있다면 괄호 쌍 실패
				ans = false;
			}
			if(ans == true) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			cnt++;
		}
	}

}