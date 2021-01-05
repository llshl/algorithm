package NDBsAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sorting_LowStudent {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		Collections.sort(Arrays.asList(arr),new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				
				return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
			}
		});
		for(int i=0;i<N;i++) {
			System.out.print(arr[i][0]+" ");
		}
	}

}
