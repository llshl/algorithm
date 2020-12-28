package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class main10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp != 0) {
				st.push(temp);
			}
			else if(temp == 0) {
				st.pop();
			}
		}
		int ans = 0;
		while(!st.isEmpty()) {
			ans += st.peek();
			st.pop();
		}
		System.out.println(ans);
	}

}
