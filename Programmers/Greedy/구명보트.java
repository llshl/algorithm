package Greedy;

import java.util.Arrays;

class Boat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int start = 0;
        for(int i=people.length-1;i>-1;i--) {
        	if(people[i] + people[start] > limit) {	//맨앞 맨뒤중에 한명만 탈수있다면
        		answer++;	//맨뒤를 보낸다(맨뒤는 i가 가리키므로 자동으로 넘어감)
        	}
        	else {		//둘다 탈수있다면
        		start++;	//맨앞과 맨뒤 둘다 보낸다(맨뒤는 i가 가리키므로 자동으로 넘어가고 맨 앞은 start++해줌)
        		answer++;
        	}
        }
        return answer;
    }
}
//50 50 70 80
public class 구명보트 {

	public static void main(String[] args) {
		Boat b = new Boat();
		int[] people = {40,50,60,90};
		int limit = 100;
		int answer = b.solution(people, limit);
		System.out.println(answer);

	}

}
