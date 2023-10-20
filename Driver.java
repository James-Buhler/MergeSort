package merge;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		int size = 1000000;
		int[] arr = GenerateRandomArray(size);
		
		long start = System.currentTimeMillis();
		MergeSort(arr, 0, size - 1);
		long end = System.currentTimeMillis();
		System.out.println("Merge Sort time for an array of length " + size + " and it took " + (end - start) + "ms");
	}
	
	public static int[] GenerateRandomArray(int size) {
		Random r = new Random();
		int[] returnVal = new int[size];
		int temp = -1;
		for(int i = 0; i < size; i++) {
			returnVal[i] = i;
		}
		for(int i = 0; i < size; i++) {
			int index = r.nextInt(size);
			if(index != i) {
				temp = returnVal[i];
				returnVal[i] = returnVal[index];
				returnVal[index] = temp;
			}
		}
		return returnVal;
	}
	
	public static void MergeSort(int[] arr, int start, int end) {
		if(start == end) {
			return;
		} else {
			int mid = (start + end) / 2;
			MergeSort(arr, start, mid);
			MergeSort(arr, mid + 1, end);
			Merging(arr, start, mid, end);
		}
	}
	
	public static void Merging(int[] arr, int start, int mid, int end) {
		int leftStart = start;
		int leftEnd = mid;
		int rightStart = mid + 1;
		int rightEnd = end;
		int[] temp = new int[end - start + 1];
		int count = 0;
		while(leftStart <= leftEnd && rightStart <= rightEnd) {
			if (arr[leftStart] < arr[rightStart]) {
				temp[count] = arr[leftStart];
				count++;
				leftStart++;
			} else {
				temp[count] = arr[rightStart];
				count++;
				rightStart++;
			}
		}
		
		while(leftStart<=leftEnd) {
			temp[count] = arr[leftStart];
			count++;
			leftStart++;
		}
		
		while(rightStart<=rightEnd) {
			temp[count] = arr[rightStart];
			count++;
			rightStart++;
		}
		
		for(int i = 0; i < count; i++) {
			arr[start] = temp[i];
			start++;
		}
	}
}
