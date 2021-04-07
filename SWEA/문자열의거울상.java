package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열의거울상 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            String input = br.readLine();
            int length = input.length();
            char[] answer = new char[length];
            for(int i=0;i<input.length();i++){
                if(input.charAt(i) == 'b'){
                    answer[length-1-i] = 'd';
                }
                if(input.charAt(i) == 'd'){
                    answer[length-1-i] = 'b';
                }
                if(input.charAt(i) == 'p'){
                    answer[length-1-i] = 'q';
                }if(input.charAt(i) == 'q'){
                    answer[length-1-i] = 'p';
                }
            }
            for(int i=0;i<length;i++){
                sb.append(answer[i]);
            }
            System.out.println("#"+t+" "+sb.toString());
            sb.delete(0,sb.length());
        }
	}
}
