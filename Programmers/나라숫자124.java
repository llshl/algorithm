package All;

class Nara {
    public String solution(int n) {
        String answer = "";
        String[] number = {"4","1","2"};
        int num = n;
        while(num > 0) {
        	int remainder = num % 3;
        	num /= 3;
        	if(remainder == 0) {
        		num--;
        	}
        	answer = number[remainder] + answer;
        }
		return answer;
    }
       
    
    
}

public class 나라숫자124 {

	public static void main(String[] args) {
		Nara s = new Nara();
		int n = 18;
		String answer = s.solution(n);
		System.out.println(answer);
	}

}
