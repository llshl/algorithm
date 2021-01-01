package BinarySearch;

import java.io.IOException;
import java.util.Arrays;
public class test {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = {1,2,5,7,4,5};
		//Arrays.sort(arr);
		int temp = Arrays.binarySearch(arr, 5);
		System.out.println(temp);
	}

}
