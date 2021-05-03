package All;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

class BAN {
	private Set<Set<String>> result;
    public int solution(String[] user_id, String[] banned_id) {
    	result = new HashSet<>();
        dfs(user_id,banned_id,new LinkedHashSet<String>());
        return result.size();
    }

	private void dfs(String[] user_id, String[] banned_id, Set<String> set) { 
		if(set.size()==banned_id.length) {
			if(isOk(set,banned_id)) {
				result.add(new HashSet<>(set));
				//result.add(set);
			}
			return;
		}
		
		for(String a : user_id) {
			if(!set.contains(a)) {
				set.add(a);
				dfs(user_id,banned_id,set);
				set.remove(a);
			}
		}
	}
	
	private boolean isOk(Set<String> set, String[] banned_id) {
		int index = 0;
		for(String a : set) {
			if(!isAvailable(a, banned_id[index++])) {
				return false;
			}
		}
		return true;
	}

	private boolean isAvailable(String s1, String s2) {
		if(s1.length() == s2.length()) {
			for(int i=0;i<s1.length();i++) {
				if(s2.charAt(i) != '*') {
					if(s1.charAt(i) != s2.charAt(i)) {
						return false;
					}
					else {
						continue;
					}
				}
				else {
					continue;
				}
			}
			return true;
		}
		return false;
	}
}


public class 불량사용자 {

	public static void main(String[] args) {
		BAN s = new BAN();
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		System.out.println(s.solution(user_id, banned_id)); 
	}
}
