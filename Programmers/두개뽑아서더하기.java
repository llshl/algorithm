package All;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
    	int[] answer;
    	TreeSet<Integer> set = new TreeSet<>();
    	for(int i=0;i<numbers.length;i++) {
    		for(int j=i+1;j<numbers.length;j++) {
    			set.add(numbers[i]+numbers[j]);
    		}
    	}
    	answer = new int[set.size()];
    	int index = 0;
    	Iterator<Integer> it = set.iterator();
    	while(it.hasNext()) {
    		answer[index] = it.next();
    		index++;
    	}
    	return answer;
    }
}
//List<Integer> list = new ArrayList<>();
//for(int i=0;i<numbers.length;i++) {
//	for(int j=i+1;j<numbers.length;j++) {
//		list.add(numbers[i]+numbers[j]);
//	}
//}
//return list.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
//=================================================
//int[] answer;
//HashSet<Integer> set = new HashSet<>();
//for(int i=0;i<numbers.length;i++) {
//	for(int j=i+1;j<numbers.length;j++) {
//		set.add(numbers[i]+numbers[j]);
//	}
//}
//answer = new int[set.size()];
//int index = 0;
//Iterator<Integer> it = set.iterator();
//while(it.hasNext()) {
//	answer[index] = it.next();
//	index++;
//}
//Arrays.sort(answer);
//return answer;
public class 두개뽑아서더하기 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numbers = {2,1,3,4,1};
		int[] answer = s.solution(numbers);
		for(int a : answer) {
			System.out.println(a);
		}
	}

}
