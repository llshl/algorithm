package String;

public class 신규아이디추천 {

	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		System.out.println(solution(new_id));
		
	}
	public static String solution(String new_id) {
		String lowerId = new_id.toLowerCase();		//모두 소문자로
		
		StringBuilder st = new StringBuilder();
		for(int i=0;i<lowerId.length();i++) {
			char temp = lowerId.charAt(i);
			if((48<=temp && temp<=57) || (97<=temp && temp<=122) || temp=='-' || temp=='_' || temp==46) {//숫자만, 밑줄, 빼기, 마침표
				st.append(temp);
			}
		}
		String Id = st.toString();	//2단계까지 완료
		StringBuilder sb = new StringBuilder();
		
		boolean flag = false;
		for(int i=0;i<Id.length();i++) {
			if(Id.charAt(i)=='.' && flag==false) {
				sb.append(Id.charAt(i));
				flag = true;
			}else if(Id.charAt(i) != '.'){
				sb.append(Id.charAt(i));
				flag = false;
			}
		}	//3단계 완료===> 마침표가 두개 이상인거는 다 한개로 치환해야한다
		
		
		Id = sb.toString();
		
		if(Id.charAt(0) == '.') {
			if(Id.length() == 1) {	//이 경우는 문자열이 . 한개일경우임
				Id = "";
			}
			else{
				Id = Id.substring(1);
			}
		}
		if(Id.length() > 0 && Id.charAt(Id.length()-1) == '.') {	//문자열이 ""인 경우엔 인덱스에러가 뜬다
			Id = Id.substring(0, Id.length()-1);		//4단계완료
		}
		
		if(Id.equals("")) {
			Id += "a";
		}	//5단계완료
		
		if(Id.length() >= 16) {
			Id = Id.substring(0, 15);
			if(Id.charAt(Id.length()-1) == '.') {
				Id = Id.substring(0, 14);
			}
		}//6단계 완료
		
		if(Id.length() <= 2) {
			while(!(Id.length()==3)) {
				Id += Id.charAt(Id.length()-1);
			}
		}
		
        String answer = Id;
        return answer;
    }

}
