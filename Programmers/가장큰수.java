package Sorting;

import java.util.Arrays;
import java.util.Comparator;

class S {
    public String solution(int[] numbers) {
        String answer = "";
        int zero = 0;
        boolean flag = false;
        String[] temp = new String[numbers.length];
        for(int i=0;i<numbers.length;i++) {
        	temp[i] = numbers[i]+"";
        	if(numbers[i] == 0) {
        		zero++;
        	}
        }
        if(zero == numbers.length) {
        	flag = true;
        }
        Arrays.sort(temp,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);	//오름차순정렬
			}
        });
        for(String a : temp) {
        	answer += a;
        }
        if(flag == true) {
        	return "0";
        }
        else {
        	return answer;
        }
    }
}

public class 가장큰수 {
	public static void main(String[] args) {
		S s = new S();
		int[] arr = {0,0,0,0,0};
		String answer = s.solution(arr);
		System.out.println(answer);
	}
}
