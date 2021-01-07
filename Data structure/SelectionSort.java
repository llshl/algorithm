package JksHomeWork;

//O(n^2)
public class SelectionSort {
	public static int[] arr = {9,0,6,7,5,-50,3,11,1,4,8,15,-1,-34,5,-34,-2,0};
	public static int minindex;
	public static boolean flag = false; 
	public static void main(String[] args) {
		Show(arr);
		System.out.println("====================정렬시작====================");
//구현========================================================================
		int min;
		minindex = -1;
		for(int i=0;i<arr.length;i++) {
			min = arr[i];
			for(int j=i+1;j<arr.length;j++) {
				if(min>arr[j]) {
					min = arr[j];
					minindex = j;	//기준 min보다 더 작은 값 찾으면 그 인덱스 저장
					flag = true;	//min보다 작은 값을 새로 찾았을때 true
				}
			}
			if(flag == true) {	//새로 갱신된 최소값이 있으면 swap
				swap(i,minindex);
				flag = false;
			}
		}
//구현========================================================================
		System.out.println("====================정렬완료====================");
		Show(arr);

	}
	private static void swap(int i, int minindex) {
		int temp = arr[i];
		arr[i] = arr[minindex];
		arr[minindex] = temp;
		Show(arr);
	}
	
	//교체가 일어날때만 출력
	public static void Show(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
}
