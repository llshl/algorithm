package NDBsAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Imple_UDLR {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] point = {1,1};
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		ArrayList<Character> list = new ArrayList<>();
		while(st.hasMoreTokens()) {
			list.add(st.nextToken().charAt(0));
		}
		int cnt=0;
		while(cnt!=list.size()) {
			if(list.get(cnt)=='R' && point[1]<N) {
				point[1]++;
			}
			else if(list.get(cnt)=='L' && point[1]>1) {
				point[1]--;
			}
			else if(list.get(cnt)=='U' && point[0]>1) {
				point[0]--;
			}
			else if(list.get(cnt)=='D' && point[0]<N) {
				point[0]++;
			}
			cnt++;
		}
		System.out.println(point[0]+" "+point[1]);
	}

}
