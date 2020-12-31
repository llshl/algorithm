package Sorting;
import java.util.HashMap;
import java.util.HashSet;
public class Sort implements SortMethod{
	//버블소트 자기 자신 뒤에 있는 값만을 비교하여 작을경우 swap 진행 아닐경우 continue
	//BigO는 최선 최악 평균의 경우 모두 n^2이 나옴 
	//모든 선형정렬중 제일 느림
	//어떤 문제를 풀던 이 정렬방법을 사용하면 시간초과
	@Override
	public int[] BubbleSort(int[] array) {
		for(int i=0; i<array.length; i++) {
			for(int j=1; j<array.length; j++) {
				if(array[j]<array[j-1]) {
					int temp=array[j];
					array[j]=array[j-1];
					array[j-1]=temp;
				}
			}
		}
		return array;
	}
	//선택정렬로 한번에 하나의 값을 min값을 찾아 차례로 정렬하는 방법
	//BigO는 n^2최악 최선 평균 모두
	//그닥 추천하는 방법은 아님 JAVA의 경우 Arrays.sort함수가 mergesort로 이루어져 있으며
	//다른 언어의 경우 QuickSort 혹은 MergeSort로 이루어 져있는것으로 알고있음
	@Override
	public int[] SelectionSort(int[] array) {
		int min=Integer.MAX_VALUE;
		int index=0;
		for(int i=0; i<array.length; i++) {
			for(int j=i; j<array.length; j++) {
				if(array[j]<min) {
					min=array[j];
					index=j;
				}
			}
			int temp=array[i];
			array[i]=array[index];
			array[index]=temp;
		} 
		return array;
	}
	//처음 0번 인덱스는 정렬되었다고 가정하고 1번 인덱스부터 0번인덱스까지 봐가면서 그값보다 큰것 바로 뒤에 넣는방법
	//일반 선형과는 다르게 BigO는 최악 평균 은 n^2이지만 최선의경우 n이나올수있음(정렬이 되어있거나 혹은 데이터를 넣으면서 정렬할경우)
	
	@Override
	public int[] InsertSort(int[] array) {
		int j=0;
		for(int i=1; i<array.length; i++) {
			int key=array[i];
			for(j=i-1; j>=0&&array[j]>key; j--) {
				array[j+1]=array[j];
			}
			array[j+1]=key;
			
		}
		return array;
	}

	@Override
	public int[] mergeSort(int[] array,int start, int end, int[] temp) {
		if(start<end) {
			int mid=(start+end)/2;
			mergeSort(array,start,mid,temp);
			mergeSort(array,mid+1,end,temp);
			
			int p=start;
			int q=mid+1;
			int index=p;
			while(p<=mid||q<=end) {
				if(q>end || (p<=mid && array[p]<array[q])) {
					temp[index++]=array[p++];
				}else {
					temp[index++]=array[q++];
				}
			}
			for(int i=start; i<=end; i++) {
				array[i]=temp[i];
			}
		}
		return array;
	}

	@Override
	public int[] QuickSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] ShellSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] RadixSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}
	//공간의 낭비가 심해 다른방법으로 Map을 사용하여 정렬가능 추후 아래 다른버전으로 만들예정
	//중복이 없어도 선형정렬에비해서 빠르긴하지만 공간복잡도가 매우 낮게 측정될 수 있음
	//Map 을 쓰면 공간복잡도 해결 가능
	@Override
	public int[] CounterSort(int[] array) {
		int max=0;
		for(int i=0; i<array.length; i++) {
			if(array[i]>max) {
				max=array[i];
			}
		}
		int[] tempArray=new int[max];
		for(int i=0; i<array.length; i++) {
			tempArray[array[i]-1]+=1;
		}
		int[] sortedArray=new int[array.length];
		int index=0;
		for(int i=0; i<tempArray.length; i++) {
			for(int j=0; j<tempArray[i]; j++) {
				sortedArray[index]=tempArray[i];
				index++;
			}
		}
		return sortedArray;
	}
	//Map과 Set을 사용하여 공간복잡도의 낭비를 줄이고(수들의 간격이 매우 클경우) 정렬함
	//총 BigO는 최악의 경우 n^2이지만 평균 BigO는 n이 나옴
	
	@Override
	public int[] CounterSortMap(int[] array) {
		HashMap<Integer,Integer> map=new HashMap<>();
		HashSet<Integer> set=new HashSet<>();
		for(int i=0; i<array.length; i++) {
			if(map.containsKey(array[i])) {
				map.put(array[i],map.get(array[i])+1);
			}else {
				map.put(array[i],1);
				set.add(array[i]);
			}
		}
		int[] sortedArray=new int[array.length];
		int index=0;
		for(int i :set) {
			int num=map.get(i);
			for(int j=0; j<num; j++) {
				sortedArray[index]=i;
				index++;
			}
		}
		return sortedArray;
	}
	
	@Override
	public int[] HeapSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void printSortedArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		return;
	}
}
