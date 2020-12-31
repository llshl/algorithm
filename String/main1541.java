package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.script.ScriptException;

public class main1541 {
	private static int calc(String a) {
		int num=0;
		String[] part = a.split("\\+");
		for(int i=0;i<part.length;i++) {
			num += Integer.parseInt(part[i]);
		}
		return num*(-1);
	}

	public static void main(String[] args) throws ScriptException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("\\-");
		int ans=0;
		for(int i=0;i<s.length;i++) {
			ans += calc(s[i]);
			if(i == 0) {
				ans *= -1;
			}
		}
		System.out.println(ans);
	}
}


/*
for(int i=0;i<s.length();i++) {
if(s.charAt(i) == '-' && flag == false){
	s=s.substring(0,i+1) + '(' + s.substring(i+1,s.length());
	flag = true;
}
else if(s.charAt(i) == '-' && flag == true ){
	s=s.substring(0,i) + ')' + s.substring(i,s.length());
	flag = false;
}
}
if(flag == true) {
s = s+')';
}
*/