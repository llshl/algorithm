package JksHomeWork;

//O(n) ~ O(n^2)
public class InsertionSort {
	public static int[] arr = {9,0,6,7,5,-50,3,11,1,4,8,15,-1,-34,5,-34,-2,0};
	public static void main(String[] args) {
		show(arr);
		System.out.println("====================정렬시작====================");
		for(int i=1;i<arr.length;i++) {
			insert(i);
			show(arr);
		}
		System.out.println("====================정렬완료====================");
		show(arr);
	}
	
	private static void insert(int i) {
		while(i!=0) {
			if(arr[i-1] > arr[i]) {
				int temp = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = temp;
				i--;
			}
			else {
				break;
			}
		}
	}
	
	public static void show(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
}
