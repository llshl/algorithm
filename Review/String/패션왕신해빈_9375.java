package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 패션왕신해빈_9375 {
	static int testcase;
	static int N;
	static String[] clothes;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		for(int t=0;t<testcase;t++) {
			int answer = 1;
			N = Integer.parseInt(br.readLine());
			clothes = new String[N];
			for(int i=0;i<N;i++) {
				String[] temp = br.readLine().split(" ");
				clothes[i] = temp[1];
			}
			//옷 종류별 개수 지정
			//(종류별개수+1) * (종류별개수+1) * (종류별개수+1) ... -1
			Map<String, Integer> map = new HashMap<>();
			for(String s : clothes) {
				if(map.containsKey(s)) {
					map.put(s, map.get(s)+1);
				}
				else {
					map.put(s, 1);	
				}
			}
			for(String key : map.keySet()) {
				answer *= (map.get(key)+1);
			}
			System.out.println(answer-1);
		}
	}
}
