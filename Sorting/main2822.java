package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class main2822 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<8;i++) {
			map.put(i+1,Integer.parseInt(br.readLine()));
		}
		list.addAll(map.keySet());	
		Collections.sort(list,new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				return map.get(o1) - map.get(o2);
			}
		});
		System.out.println(map.get(list.get(3))+map.get(list.get(7))+map.get(list.get(6))+map.get(list.get(5))+map.get(list.get(4)));
		list.remove(0);list.remove(0);list.remove(0);
		Collections.sort(list);
		System.out.print(list.get(0)+" ");
		System.out.print(list.get(1)+" ");
		System.out.print(list.get(2)+" ");
		System.out.print(list.get(3)+" ");
		System.out.print(list.get(4)+" ");	
	}
}
