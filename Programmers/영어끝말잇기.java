package All;

import java.util.HashSet;

class ENG {
    public int[] solution(int n, String[] words) {
    	boolean flag = false;
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        char temp = words[0].charAt(words[0].length()-1);	//첫단어의 마지막 글자
        set.add(words[0]);
        
        for(int i=1;i<words.length;i++) {
        	if(!set.contains(words[i]) && words[i].charAt(0) == temp) {
        		set.add(words[i]);
        		temp = words[i].charAt(words[i].length()-1); 
        	}
        	else {
        		flag = true;
        		answer[0] = (i%n)+1;
        		answer[1] = (i/n)+1;
        		break;
        	}
        }
        if(!flag) {
        	answer[0] = 0;
        	answer[1] = 0;
        }
        return answer;
    }
}


public class 영어끝말잇기 {

	public static void main(String[] args) {
		ENG s = new ENG();
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int n = 3;
		int[] answer = s.solution(n, words);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}
}
