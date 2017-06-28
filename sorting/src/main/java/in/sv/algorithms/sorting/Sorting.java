package in.sv.algorithms.sorting;

public class Sorting {

	/**
	 * Time Complexity: O(n2) BestCase: O(n) if array is sorted
	 * 
	 * @param inputArr
	 * @return
	 */
	public static int[] bubbleSort(int[] inputArr) {

		int inputLen = inputArr.length;

		for (int i = 0; i < inputLen; i++) {

			boolean isSwapped = false;

			for (int j = 0; j < inputLen - 1; j++) {

				if (inputArr[j] > inputArr[j + 1]) {

					int temp = inputArr[j];

					inputArr[j] = inputArr[j + 1];

					inputArr[j + 1] = temp;

					isSwapped = true;

				}
			}

			if (!isSwapped) {

				break;
			}

		}

		return inputArr;

	}

	/*
	 * Time Complexity: O(n2) Space COmplexity: O(1)
	 */
	public static int[] selectionSort(int[] inputArr) {

		int inputLen = inputArr.length;

		int min, temp;

		for (int i = 0; i < inputLen - 1; i++) {

			min = i;

			for (int j = i + 1; j < inputLen; j++) {

				if (inputArr[j] < inputArr[min]) {

					min = j;

				}

				temp = inputArr[min];

				inputArr[min] = inputArr[i];

				inputArr[i] = temp;

			}

		}

		return inputArr;
	}

	public static int[] insertionSort(int[] inputArr) {

		int inputLen = inputArr.length;

		for (int i = 1; i < inputLen; i++) {

			int key = inputArr[i];

			int j = i - 1;

			while (j >= 0 && inputArr[j] > key) {

				inputArr[j + 1] = inputArr[j];

				j = j - 1;

			}

			inputArr[j + 1] = key;

		}

		return inputArr;
	}

	public static int[] shellSort(int[] inputArr) {

		int inputLen = inputArr.length;

		for (int gap = inputLen / 2; gap > 0; gap /= 2) {
			// Do a gapped insertion sort for this gap size.
			// The first gap elements a[0..gap-1] are already
			// in gapped order keep adding one more element
			// until the entire array is gap sorted

			for (int i = gap; i < inputLen; i += 1) {

				// add a[i] to the elements that have been gap
				// sorted save a[i] in temp and make a hole at
				// position i
				int temp = inputArr[i];

				// shift earlier gap-sorted elements up until
				// the correct location for a[i] is found
				int j;
				for (j = i; j >= gap && inputArr[j - gap] > temp; j -= gap) {

					inputArr[j] = inputArr[j - gap];

				}

				// put temp (the original a[i]) in its correct
				// location
				inputArr[j] = temp;
			}
		}

		return inputArr;
	}

	public static int[] heapSort(int[] inputArr) {

		int inputLen = inputArr.length;

		int[] arr = new int[inputLen + 1];

		arr[0] = inputLen;

		for (int i = 1; i <= inputLen; i++) {

			arr[i] = inputArr[i - 1];

		}

		buildHeap(arr, inputLen);

		heapify(arr);

		for (int i = 0; i < inputLen; i++) {

			inputArr[i] = arr[i + 1];

		}

		return inputArr;
	}

	private static void heapify(int[] arr) {

		while (arr[0] > 0) {

			int temp = arr[1];

			arr[1] = arr[arr[0]];

			arr[arr[0]] = temp;

			buildHeap(arr, arr[0]);

			arr[0]--;

		}

	}

	private static void buildHeap(int[] inputArr, int n) {

		for (int i = 1; i < n; i++) {

			int index = i;

			while ((inputArr[index / 2] < inputArr[index]) && (index / 2) != 0) {

				int temp = inputArr[index / 2];

				inputArr[index / 2] = inputArr[index];

				inputArr[index] = temp;

				index = index / 2;

			}

		}

	}

	public static int[] quickSort(int[] inputArr) {

		int len = inputArr.length;
		
		quickSort(inputArr, 0, len-1);

		return inputArr;
	}

	public static void quickSort(int[] inputArr, int startIndex, int endIndex) {

		if (startIndex < endIndex) {

			int pivotIndex = partition(inputArr, startIndex, endIndex);

			quickSort(inputArr, startIndex, pivotIndex - 1);

			quickSort(inputArr, pivotIndex + 1, endIndex);

		}

	}

	private static int partition(int[] inputArr, int startIndex, int endIndex) {
		
		int pivot = inputArr[endIndex];
		
		int i = startIndex;
		
		for (int j = startIndex; j < endIndex; j++){
			
			if (inputArr[j] <= pivot){
				
				int temp = inputArr[i];
				
				inputArr[i] = inputArr[j];
				
				inputArr[j] = temp;
				
				i++;
				
			}
		}
		
		int temp1 = inputArr[i];
		
		inputArr[i] = inputArr[endIndex];
		
		inputArr[endIndex] = temp1;
		
		return i;

	}

	public static int[] mergeSort(int[] inputArr) {

		int len = inputArr.length;

		if (len == 1) {

			return inputArr;

		} else {

			mergeSort(0, len - 1, inputArr);

		}

		return inputArr;
	}

	private static void mergeSort(int i, int j, int[] arr) {

		if (i < j) {

			int middle = i + (j - i) / 2;

			mergeSort(i, middle, arr);

			mergeSort(middle + 1, j, arr);

			mergeParts(i, middle, j, arr);

		}

	}

	private static void mergeParts(int lowerIndex, int middle, int higherIndex, int[] inputArr) {

		int[] tempMergArr = new int[inputArr.length];

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = inputArr[i];
		}

		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;

		while (i <= middle && j <= higherIndex) {

			if (tempMergArr[i] < tempMergArr[j]) {

				inputArr[k] = tempMergArr[i];

				i++;

			} else {

				inputArr[k] = tempMergArr[j];

				j++;

			}

			k++;

		}

		while (i <= middle) {
			inputArr[k] = tempMergArr[i];

			k++;

			i++;
		}

	}

	public static int[] radixSort(int[] inputArr) {

		return inputArr;
	}

	public static void main(String args[]) {

		int[] inputArr = { 40, 25, 13, 56, 10 };

		// int[] outputArr = Sorting.bubbleSort(inputArr);
		// int[] outputArr = Sorting.selectionSort(inputArr);
		// int[] outputArr = Sorting.insertionSort(inputArr);
		// int[] outputArr = Sorting.shellSort(inputArr);
		// int[] outputArr = Sorting.heapSort(inputArr);
		// int[] outputArr = Sorting.mergeSort(inputArr);
		int[] outputArr = Sorting.quickSort(inputArr);

		printArr(outputArr, 0);

	}

	private static void printArr(int[] outputArr, int startIndex) {
		for (int i = startIndex; i < outputArr.length; i++) {

			System.out.println(outputArr[i]);
		}
	}

}
