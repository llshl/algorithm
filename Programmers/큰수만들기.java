package Greedy;
class Big {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int answerLen = number.length() - k;
        int max = 0;
        int stage = 0;
        int start = 0;
        while(sb.length() != answerLen) {
	        for(int i=start;i<=number.length()-answerLen+stage;i++) {
	        	if(max < number.charAt(i)-'0') {
	        		max =  number.charAt(i)-'0';
	        		start = i+1;
	        	}
	        }
	        sb.append(max+"");
	        stage++;
	        max = 0;
        }
        answer = sb.toString();
        return answer;
    }
}

public class 큰수만들기 {

	public static void main(String[] args) {
		Big s = new Big();
		String number = "1231234";
		int k = 2;
		String answer = s.solution(number, k);
		System.out.println(answer); 

	}

}
