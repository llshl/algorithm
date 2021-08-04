package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

class Log{
	String uid;
	String type;
	public Log(String uid, String type) {
		super();
		this.uid = uid;
		this.type = type;
	}
}

class OPEN {
    public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        //Enter와 Leave로 해쉬맵에서 넣고 빼기 결정
        //uid가 key
        //닉네임이 value
        //모든 시뮬레이션 후 해쉬맵 
        List<Log> list = new ArrayList<>();
        HashMap<String, String> nameStatus = new HashMap<>();		//해당 사용자의 최종 닉네임 상태
        for(String s : record) {
        	String[] temp = s.split(" ");
        	
        	if(temp[0].charAt(0) == 'E') {
        		list.add(new Log(temp[1], temp[0]));
        		if(nameStatus.containsKey(temp[1])) {
        			nameStatus.replace(temp[1], temp[2]);
        		}
        		else {
        			nameStatus.put(temp[1], temp[2]);
        		}
        	}
        	else if(temp[0].charAt(0) == 'L') {
        		list.add(new Log(temp[1], temp[0]));
        	}
        	else if(temp[0].charAt(0) == 'C') {
        		if(nameStatus.containsKey(temp[1])) {
        			nameStatus.replace(temp[1], temp[2]);
        		}
        		else {
        			nameStatus.put(temp[1], temp[2]);
        		}
        	}
        }
        
        for(Log l : list) {
        	if(l.type.equals("Enter")) {
        		String nickname = nameStatus.get(l.uid);
        		//System.out.println(nickname+"님이 들어왔습니다.");
        		answer.add(nickname+"님이 들어왔습니다.");
        	}else{
        		String nickname = nameStatus.get(l.uid);
        		//System.out.println(nickname+"님이 나갔습니다.");
        		answer.add(nickname+"님이 나갔습니다.");
        	}
        }
        return answer;
    }
}

public class 오픈채팅방 {

	public static void main(String[] args) {
		OPEN s = new OPEN();
		String[] input = {"Enter uid1234 Muzi", 
				"Enter uid4567 Prodo",
				"Leave uid1234",
				"Enter uid1234 Prodo",
				"Change uid4567 Ryan"};
		s.solution(input);
	}
}
