package All;

import java.util.LinkedList;
import java.util.Queue;

class passedWord{
	String word;
	int cnt;
	public passedWord(String word, int cnt) {
		super();
		this.word = word;
		this.cnt = cnt;
	}
}

class Dan {
    public int solution(String begin, String target, String[] words) { 
    	int answer = 0;
    	boolean[] visit = new boolean[words.length];
    	Queue<passedWord> q = new LinkedList<>();
    	for(int i=0;i<words.length;i++) {
    		if(diff(begin, words[i])) {	//다른글자1개 T/F
    			q.add(new passedWord(words[i], 1));
    			visit[i] = true;
    		}
    	}
    	while(!q.isEmpty()) {
    		passedWord word = q.poll();
    		if(word.word.equals(target)) {
    			answer = word.cnt;
    			break;
    		}
    		for(int i=0;i<words.length;i++) {
        		if(diff(word.word, words[i]) && visit[i] == false) {	//다른글자1개 T/F
        			q.add(new passedWord(words[i], word.cnt+1));
        			visit[i] = true;
        		}
        	}
    	}
		return answer;
    }

	private boolean diff(String begin, String string) {
		int cnt = 0;
		for(int i=0;i<begin.length();i++) {
			if(begin.charAt(i) == string.charAt(i)) {
				cnt++;
			}
		}
		return begin.length()-cnt == 1;
	}        
}

public class 단어변환2 {
	public static void main(String[] args) {
		Dan s = new Dan();
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot","dot","dog","lot","log","cog"};
		int answer = s.solution(begin, target , words);
		System.out.println(answer);
	}
}
