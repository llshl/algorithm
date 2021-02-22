package All;

class haesihaesi {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i=0;i<phone_book.length;i++) {
        	int len = phone_book[i].length();
        	for(int j=i+1;j<phone_book.length;j++) {
        		//비교기준 길이보다 비교대상 길이가 더 큰경우 && 비교기준 해시값과 비교대상 해시값(비교기준과 같은길이까지의)이 같은경우
        		//ex) 119와 1193424
        		if(len <= phone_book[j].length() && phone_book[i].hashCode() == phone_book[j].subSequence(0, len).hashCode()) {
        			return false;
        		}
        		//비교 대상이 더 큰경우
        		//11925와 119
        		if(len > phone_book[j].length() && phone_book[i].substring(0,phone_book[j].length()).hashCode() == phone_book[j].hashCode()) {
        			return false;
        		}
        	}
        }
        return answer;
    }
}

public class 전화번호목록 {

	public static void main(String[] args) {
		haesihaesi s = new haesihaesi();
		String[] phone = {"119","976764223","16195524421"};
		System.out.println(s.solution(phone));

	}

}
