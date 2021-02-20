package All;

import java.util.HashMap;

class M {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for(String s : participant) {
        	if(hm.get(s) == null) {	//중복X라면
        		hm.put(s, hm.getOrDefault(s, 0)+1);	//s라는 key가 있으면 그 키반환후 +1, 없으면 0반환 후 +1
        	}
        }
        for(String s : completion) {
        	hm.put(s, hm.get(s)-1);	//해당 키값 s의 value를 -1해서 다시넣음
        }
        for(String s : hm.keySet()) {
        	if(hm.get(s) != 0) {		//위에서 1씩 빼주기를 반복했으니 다 0이어야함
        		return s;	
        	}
        }
        return null;
    }
}

/*
 * String answer = ""; Arrays.sort(participant); Arrays.sort(completion); int
 * index = -1; for(int i=0;i<participant.length;i++) { try {
 * if(!participant[i].equals(completion[i])) { index = i; break; }
 * }catch(Exception e) { index = participant.length-1; } } return
 * participant[index];
 */
public class 완주하지못한선수 {

	public static void main(String[] args) {
		M s = new M();
		String[] p = {"marina","josipa","marina","vinko"};
		String[] c = {"josipa","marina","marina"};
		String answer = s.solution(p, c);
		System.out.println(answer);
	}

}
