package Sorting;
import java.util.ArrayList;
public interface SortMethod {
	int[] BubbleSort(int[] array);
	int[] SelectionSort(int[] array);
	int[] InsertSort(int[] array);
	
	int[] mergeSort(int[] array,int start,int end,int[] temp);
	int[] QuickSort(int[] array);
	int[] ShellSort(int[] array);
	
	int[] RadixSort(int[] array);
	int[] CounterSort(int[] array);
	int[] CounterSortMap(int[] array);
	int[] HeapSort(int[] array);
	
	void printSortedArray(int[] array);
	
}
