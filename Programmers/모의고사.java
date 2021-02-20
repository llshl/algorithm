package All;

import java.util.ArrayList;
import java.util.List;

class Supo {
    public List<Integer> solution(int[] answers) {
        int[] answer = new int[3];
        int[][] supo = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        for(int t=0;t<supo.length;t++) {
        	int index = 0;
            int answerIndex = 0;
	       	while(answerIndex != answers.length) {
	        	if(answers[answerIndex] == supo[t][index % supo[t].length]) {	//index / 5 => 0,1,2,3,4,0,1,2,3,4
	        		answer[t]++;
	        	}
	        	index++;
	        	answerIndex++;
	        }
        }
        int max = -1;
        for(int a : answer) {
        	if(a >= max) {
        		max = a;
        	}
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<3;i++) {
        	if(answer[i] == max) {
        		list.add(i+1);
        	}
        }
        return list;
    }
}

public class 모의고사 {
	public static void main(String[] args) {
		Supo s = new Supo();
		int[] answers = {1,3,2,4,2};
		List<Integer> list = s.solution(answers);
		for(int a : list) {
			System.out.println(a);
		}
	}
}
