package All;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Tuple {
    public List<Integer> solution(String s) {
    	List<String[]> list = new ArrayList<>();
    	HashMap<Integer, String[]> map = new HashMap<>();
    	StringBuilder sb = new StringBuilder();
    	boolean flag = false;
    	for(int i=1;i<s.length()-1;i++) {
    		if(s.charAt(i) == '{') {
    			flag = true;
    		}
    		else if(flag && s.charAt(i) != '}') {
    			sb.append(s.charAt(i));
    		}
    		else if(s.charAt(i) == '}') {
    			flag = false;
    			String temp = sb.toString();
    			
    			sb.delete(0, sb.length());
    			
    			String[] token = temp.split(",");
    			map.put(token.length, token);
    			list.add(token);
    		}
    	}
    	List<Integer> answer = new ArrayList<>();
    	Object[] mapkey = map.keySet().toArray();
    	Arrays.sort(mapkey);
    	Set<String> set = new HashSet<>();
    	for(Integer key : map.keySet()) {
    		for(String str : map.get(key)) {
//    			if(!answer.contains(Integer.parseInt(str))) {
//    				answer.add(Integer.parseInt(str));
//    			}
    			//contain대신 set쓰는게 제일빠름
    			if(set.add(str)) {
    				answer.add(Integer.parseInt(str));
    			}
    		}
    	}
        return answer;
    }
}


//이게더빠름
class Tuple2 {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) {
                	answer[idx++] = Integer.parseInt(s2);
                }
            }
        }
        return answer;
    }
}

public class 튜플 {

	public static void main(String[] args) {
		Tuple s = new Tuple();
		Tuple2 s2 = new Tuple2();
		String w = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
//		int[] answer2 = s2.solution(w);
//		for(int a : answer2) {
//			System.out.print(a+" ");
//		}
		List<Integer> answer = s.solution(w);
		for(int a : answer) {
			System.out.print(a+" ");
		}
	}
}
