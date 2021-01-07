package JksHomeWork;

//O(n^2)
public class BubbleSort {
	public static int[] arr = {9,0,6,7,5,-50,3,11,1,4,8,15,-1,-34,5,-34,-2,0};
	public static void main(String[] args) {
		show(arr);
		System.out.println("====================정렬시작====================");
		for(int i=0;i<arr.length;i++) {
			for(int j=1;j<arr.length;j++) {
				if(arr[j-1]>arr[j]) {
					swap(j-1,j);
					show(arr);
				}
			}
		}
		System.out.println("====================정렬완료====================");
		show(arr);
	}
	private static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void show(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
}