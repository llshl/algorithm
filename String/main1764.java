package String;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class main1764 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashSet<String> hs1 = new HashSet<String>();
		HashSet<String> hs2 = new HashSet<String>();
		Vector<String> v = new Vector<String>();

		for(int i=0;i<N;i++) {
			String temp = sc.next();
			hs1.add(temp);
		}					
		for(int i=0;i<M;i++) {
			String temp2 = sc.next();
			hs2.add(temp2);
		}

		hs1.retainAll(hs2);
		Iterator it = hs1.iterator();
		System.out.println(hs1.size());
		while(it.hasNext()) {
			v.add((String) it.next());
		}
		Collections.sort(v);
		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i));
		}	
	}
}
