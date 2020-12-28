package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] list = new int[26];
		
		for(int i=0;i<s.length();i++) {
			list[(int)s.charAt(i)-97]++;
		}
		for(int i=0;i<26;i++) {
			System.out.print(list[i]+" ");
		}
	}

}
