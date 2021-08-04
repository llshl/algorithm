package Programmers;

import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        int index = 0;
        
        while(true) {
        	if(index >= s.length()) {
        		break;
        	}
        	if(st.isEmpty()) {
        		st.add(s.charAt(index++));
        		continue;
        	}
        	char top = st.peek();
        	char now = s.charAt(index);
        	if(top == now) {
        		st.pop();
        		index++;
        	}
        	else {
        		st.add(s.charAt(index++));
        	}
        }
        return st.isEmpty() ? 1 : 0;
    }
}

public class 짝지어제거하기 {
	public static void main(String[] args) {
		Solution s = new Solution();
		String temp = "cdcd";
		System.out.println(s.solution(temp));

	}
}
