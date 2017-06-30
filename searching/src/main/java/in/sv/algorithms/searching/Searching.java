package in.sv.algorithms.searching;

public class Searching {

	public static void main(String args[]) {

		int[] inputArr = { 12, 14, 37, 68, 98 };

		// int result = Searching.unsortedLinearSearch(inputArr, 98);

		// int result = Searching.sortedLinearSearch(inputArr, 75);

		int result = Searching.binarySearchRecursive(inputArr, 68);

		System.out.println(result);

	}

	public static int unsortedLinearSearch(int[] a, int searchData) {

		int inputLen = a.length;

		for (int i = 0; i < inputLen; i++) {

			if (a[i] == searchData) {

				return a[i];

			}

		}

		return -1;

	}

	public static int sortedLinearSearch(int[] a, int searchData) {

		int inputLen = a.length;

		for (int i = 0; i < inputLen; i++) {

			if (a[i] == searchData) {

				return a[i];

			} else if (a[i] > searchData) {

				return -1;

			}

		}

		return -1;

	}

	public static int binarySearchRecursive(int[] a, int searchData) {

		int inputLen = a.length;

		int index = binarySearch(a, 0, inputLen - 1, searchData);

		return index;
	}

	private static int binarySearch(int[] a, int i, int j, int searchData) {

		int mid = i + (j - i) / 2;

		if (a[mid] == searchData) {

			return mid;

		} else if (searchData < a[mid]) {

			return binarySearch(a, i, mid - 1, searchData);

		} else {

			return binarySearch(a, mid + 1, j, searchData);

		}

	}

}
