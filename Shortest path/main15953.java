package Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main15953 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ansA = 0;
			int ansB = 0;
			int ans = 0;
			int firstPrize = 0;
			int secondPrize = 0;
			boolean inRangeA = false;
			boolean inRangeB = false;
			if(a!=0) {
				for(int i=1;i<=6;i++) {
					firstPrize += i;
					if(firstPrize >= a) {
						ansA = i;
						inRangeA = true;
						break;
					}
				}
			}
			if(b!=0) {
				for(int i=0;i<=4;i++) {
					secondPrize += (int) Math.pow(2, i);
					if(secondPrize >= b) {
						ansB = i+1;
						inRangeB = true;
						break;
					}
				}
			}
			if(inRangeA) {
				if(ansA == 1) {
					ans += 5000000;
				}
				else if(ansA == 2) {
					ans += 3000000;
				}
				else if(ansA == 3) {
					ans += 2000000;
				}
				else if(ansA == 4) {
					ans += 500000;
				}
				else if(ansA == 5) {
					ans += 300000;
				}
				else if(ansA == 6) {
					ans += 100000;
				}
			}
			if(inRangeB) {
				if(ansB == 1) {
					ans += 5120000;
				}
				else if(ansB == 2) {
					ans += 2560000;
				}
				else if(ansB == 3) {
					ans += 1280000;
				}
				else if(ansB == 4) {
					ans += 640000;
				}
				else if(ansB == 5) {
					ans += 320000;
				}
			}
			System.out.println(ans);
		}
	}
}

/*
switch(ansA) {
	case 1: ans+=500;
	break;
	case 2: ans+=300;
	break;
	case 3: ans+=200;
	break;
	case 4: ans+=50;
	break;
	case 5: ans+=30;
	break;
	case 6: ans+=10;
	break;
	default: 
}
switch(ansB) {
	case 1: ans+=512;
	break;
	case 2: ans+=256;
	break;
	case 3: ans+=128;
	break;
	case 4: ans+=64;
	break;
	case 5: ans+=32;
	break;
}
*/