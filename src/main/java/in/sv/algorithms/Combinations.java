package in.sv.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

	public static List<int[]> getCombinations(int[] a, int n) {

		List<int[]> resultList = new ArrayList<int[]>();

		if (n == a.length) {

			resultList.add(a);

			return resultList;

		} else if (n > a.length) {

			return resultList;

		} else {

			for (int i = 0; i < a.length; i++) {

				int[] arr = new int[n];

				arr[0] = a[i];

				if (n > 1) {

					for (int j = i + 1; a.length - j + 1 >= n; j++) {

						int temp = j;

						for (int k = 1; k <= n - 1 && temp < a.length; k++) {

							arr[k] = a[temp];

							temp++;

						}

						copyArray(resultList, arr);

					}

				} else {

					copyArray(resultList, arr);

				}

			}

			return resultList;

		}

	}

	private static void copyArray(List<int[]> resultList, int[] arr) {
		int[] tempArr = Arrays.copyOf(arr, arr.length);

		resultList.add(tempArr);
	}

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5 };

		for (int i = 1; i <= a.length; i++) {

			List<int[]> list = getCombinations(a, i);

			printArrayList(list);
		}
	}

	public static boolean isEven(int n) {
		return (n % 2 == 0);
	}

	private static void printArrayList(List<int[]> list) {
		for (int i = 0; i < list.size(); i++) {

			printArray(list.get(i));

		}
	}

	private static void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");

		}
		System.out.println("");
	}

}
