package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] list = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		String s = br.readLine();
		
		for(int i=0;i<list.length;i++) {
			if(s.contains(list[i])) {
				s = s.replaceAll(list[i],"*");
			}
		}
		System.out.println(s.length());
	}

}
