package All;

import java.util.HashMap;

class Closet {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hp = new HashMap<>();
        for(int i=0;i<clothes.length;i++) {
        	hp.put(clothes[i][1], hp.getOrDefault(clothes[i][1],0)+1); 
        }
        for(String key : hp.keySet()) {
        	answer *= hp.get(key)+1;
        }
        return answer-1;
    }
}

public class À§Àå {

	public static void main(String[] args) {
		Closet s = new Closet();
		String[][] cl = {{"yellow_hat","head"},{"blue_sunglasses","head"},{"green_turbun","head"}};
		System.out.println(s.solution(cl));
	}
}
