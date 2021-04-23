package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class main9935 {

	public static Character[] output;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String bomb = br.readLine();
		char first = bomb.charAt(0);
		int len = input.length();
		output = new Character[len];
		
		Stack<Character> st = new Stack<>();
		for(int i=0;i<len;i++) {
			st.add(input.charAt(len-1-i));
			if(st.peek() == first && st.size()>=bomb.length()) {
				boolean flag = true;
				for(int j=1;j<bomb.length();j++) {
					if(st.get(st.size()-1-j) != bomb.charAt(j)){
						flag = false;
						break;
					}
				}
				if(flag) {	//bomb과 모든 글자가 일치하면
					for(int j=0;j<bomb.length();j++) {
						st.pop();
					}
				}
			}
		}
		String answer = "";
		StringBuilder sb = new StringBuilder();
		if(st.isEmpty()) {
			answer = "FRULA";
		}
		else {
			int size = st.size();
			for(int i=0;i<size;i++) {
				sb.append(st.pop());
			}
			answer = sb.toString();
		}
		System.out.println(answer);
	}


}
