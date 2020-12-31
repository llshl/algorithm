package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class main10825 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][4];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
			arr[i][2] = st.nextToken();
			arr[i][3] = st.nextToken();
		}
		Arrays.sort(arr,new Comparator<String[]>() {
			public int compare(String[]a, String[]b) {
				if((a[1].equals(b[1])) && (a[2].equals(b[2]) && (a[3].equals(b[3])))) {
					return a[0].compareTo(b[0]);
				}
				else if((a[1].equals(b[1])) && (a[2].equals(b[2]))) {
					return Integer.parseInt(b[3])-Integer.parseInt(a[3]);
				}
				else if(a[1].equals(b[1])) {
					return Integer.parseInt(a[2])-Integer.parseInt(b[2]);
				}
				return Integer.parseInt(b[1])-Integer.parseInt(a[1]);
			}
		});
		for(int i=0;i<N;i++) {
			sb.append(arr[i][0]).append("\n");
		}
		System.out.println(sb);
	}
}
