package All;

import java.util.ArrayList;
import java.util.List;

class  Skill {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0;i<skill_trees.length;i++) {
        	int cnt = 0;
        	char[] temp = skill_trees[i].toCharArray();
        	List<Character> list = new ArrayList<>();
        	for(char c : temp) {
        		if(isIn(c,skill)) {
        			list.add(c);
        			//System.out.print(c+" ");
        		}
        	}
        	//list에 스킬트리인풋 한개마다의 BCD만 남아있음
        	int length = 0;
        	if(skill.length() == list.size()) {
        		length = skill.length();
        	}
        	else {
        		length = list.size();
        	}
        	for(int j=0;j<length;j++) {
        		if(list.get(j) == skill.charAt(j)) {
        			cnt++;
        		}
        	}
        	if(cnt == length) {
        		answer++;
        	}
        	//System.out.println("");
        }
        return answer;
    }

	private boolean isIn(char c, String skill) {
		boolean flag = false;
		for(int i=0;i<skill.length();i++) {
			if(c == skill.charAt(i)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}

public class 스킬트리 {
	public static void main(String[] args) {
		Skill s = new Skill();
		String skill = "CBD";
		String[] skill_trees = {"ACDE","CBADF","AECB","CBDA"};
		System.out.println(s.solution(skill, skill_trees));
	}
}
