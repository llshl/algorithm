package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sol {
    public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        for(int i=0;i<name.length();++i) {
        	answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
        	
        	int next = i+1;
        	while(next < name.length() && name.charAt(i) == 'A') {
        		next++;
        	}
        	move = Math.min(move, i+name.length()-next+i);
        }
        answer += move;
        return answer;
    }
}


public class Á¶ÀÌ½ºÆ½ {

	public static void main(String[] args) {
		Sol s = new Sol();
		String name = "JEROEN";
		int answer = s.solution(name);
		System.out.println(answer);

	}

}
