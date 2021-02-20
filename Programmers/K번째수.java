package Sorting;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int t=0;t<commands.length;t++) {
        	int size = commands[t][1] - commands[t][0] + 1;
        	int[] temp = new int[size];
        	int index = 0;
        	for(int i=commands[t][0]-1;i<=commands[t][1]-1;i++) {
        		temp[index] = array[i];
        		index++;
        	}
        	Arrays.sort(temp);
        	answer[t] = temp[commands[t][2]-1];
        	
        }
        return answer;
    }
}

public class K¹øÂ°¼ö {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		int[] answer = s.solution(arr, commands);
		for(int a : answer) {
			System.out.println(a);
		}
	}

}
