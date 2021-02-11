package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

class Change{
	private int times;		//바뀐횟수
	private String nowWord;	//현재 단어상태
	private boolean[] visit;
	
	public boolean[] getVisit() {
		return visit;
	}
	public void setVisit(boolean[] visit) {
		this.visit = visit;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public String getNowWord() {
		return nowWord;
	}
	public void setNowWord(String nowWord) {
		this.nowWord = nowWord;
	}
	public Change(int times, String nowWord, boolean[] visit) {
		super();
		this.times = times;
		this.nowWord = nowWord;
		this.visit = visit;
	}
}

public class 단어변환 {
	public static void main(String[] args) {
		String[] words = {"hot","dot","dog","lot","log","cog"};
		String begin = "hit";
		String target = "cog";
		int answer = 0;
		boolean[] visit = new boolean[words.length];
		
		Queue<Change> q = new LinkedList<>();
		q.offer(new Change(0,begin,visit)); 
		while(!q.isEmpty()) {
			Change now = q.poll();
			int time = now.getTimes();	//현재까지 바뀐 횟수
			String word = now.getNowWord();	//현재 단어
			boolean[] nowVisit = now.getVisit();
			
			if(word.equals(target)) {	//단어 완성되면 걸린 횟수 반환
				answer = time;
				break;
			}
			
			for(int i=0;i<words.length;i++) {
				if(diff(word,words[i]) == 1 && nowVisit[i] == false) {	//다른글자 개수 파악 함수
					nowVisit[i] = true;
					q.offer(new Change(time+1,words[i],nowVisit)); 
				}
			}
		}
		System.out.println(answer);
	}

	private static int diff(String word1, String word2) {
		int cnt = 0;
		for(int i=0;i<word1.length();i++) {
			if(word1.charAt(i) == word2.charAt(i)) {
				cnt++;	//같은글자개수
			}
		}
		return word1.length()-cnt;	//전체길이-같은글자 == 1이어야한다
	}

}
