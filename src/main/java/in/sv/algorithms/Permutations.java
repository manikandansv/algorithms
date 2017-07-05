package in.sv.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {

	public static boolean getPermutationsByCollectionsAPI(List<Integer> list) {

		int i = list.size() - 2;
		while (i >= 0 && list.get(i) >= list.get(i + 1))
			i--;

		if (i < 0)
			return false;

		int j = list.size() - 1;
		while (list.get(i) >= list.get(j))
			j--;

		Collections.swap(list, i, j);
		Collections.reverse(list.subList(i + 1, list.size()));
		return true;

	}

	/** Heap's Algorithm */
	public static List<int[]> getPermutations(int[] a) {

		int noOfPermutations = Factorial.getFactorial(a.length);

		List<int[]> resultList = new ArrayList<int[]>(noOfPermutations);

		generatePermutation(a, a.length, resultList);

		if (resultList.size() == noOfPermutations) {

			System.out.println("Valid Permutations = "+resultList.size());

		}

		return resultList;
	}

	private static void generatePermutation(int[] a, int length, List<int[]> resultList) {

		if (length == 1) {

			int[] temp = Arrays.copyOf(a, a.length);

			resultList.add(temp);

		} else {

			for (int i = 0; i < length; i++) {

				generatePermutation(a, length - 1, resultList);

				if (isEven(length)) {

					int temp = a[0];

					a[0] = a[length - 1];

					a[length - 1] = temp;

				} else {

					int temp = a[i];

					a[i] = a[length - 1];

					a[length - 1] = temp;

				}

			}

		}

	}

	public static void swap(int a, int b) {

		int temp = a;

		a = b;

		b = temp;

	}

	public static boolean isEven(int n) {

		if (n % 2 == 0) {

			return true;
		}

		return false;

	}

	public static void main(String[] args) {
		// List<Integer> a = Arrays.asList(new Integer[] {1, 2, 3, 4});
		// int i=0;
		//
		// do {
		// i++;
		// System.out.println("Permutation " + i + " " + a);
		// } while (getPermutationsByCollectionsAPI(a));
		int[] a = { 1, 2, 3, 4, 5 };
		List<int[]> permutationList = getPermutations(a);

		printResultList(permutationList);

	}

	private static void printResultList(List<int[]> permutationList) {

		for (int i = 0; i < permutationList.size(); i++) {

			int[] array = permutationList.get(i);

			printArray(array);
		}
	}

	private static void printArray(int[] array) {

		for (int j = 0; j < array.length; j++) {

			System.out.print(array[j] + " ");

		}

		System.out.println("");
	}

}
