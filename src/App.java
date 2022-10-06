import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import sort.Sort;

public class App {
  
	@SuppressWarnings("unchecked")
	public static <E extends Comparable<E>> ArrayList<E> createRandomArray(int arrayLength, String typeName) {
		ArrayList<E> arrayList = new ArrayList<E>(arrayLength);
		Random random = new Random();
		for (int i = 0; i < arrayLength; i++) {
			switch (typeName) {
				case "Integer":
					arrayList.add((E) (Integer) random.nextInt(100));
					break;
				case "Float":
					arrayList.add((E) (Float) random.nextFloat(100));
					break;
				case "Double":
					arrayList.add((E) (Double) random.nextDouble(100));
					break;
				default:
					System.out.println(typeName + " is not handled!");
					break;
			}
		}
		return arrayList;
	}

	@SuppressWarnings("unchecked")
	public static <E extends Comparable<E>> void main(String[] args) throws Exception {
		long startTime;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("What is the length of a random array to be created? Please enter an integer:");
			int arrayLength = scanner.nextInt();
			System.out.println("Please choose a data type:\n" + "1: Integer\n" + "2: Float\n" + "3: Double\n" +
					"Please enter 1, 2, or 3:");
			int choice = scanner.nextInt();
			ArrayList<E> arrayList = new ArrayList<>(arrayLength);
			switch (choice) {
				case 1:
					arrayList = createRandomArray(arrayLength, "Integer");
					break;
				case 2:
					arrayList = createRandomArray(arrayLength, "Float");
					break;
				case 3:
					arrayList = createRandomArray(arrayLength, "Double");
					break;
				default:
					System.out.println("The input is not valid. Create an integer array instead.");
					arrayList = createRandomArray(arrayLength, "Integer");
			}
			ArrayList<E> copyArrayList = (ArrayList<E>) arrayList.clone();

			System.out.println("Please choose:\n" + "1: MergeSort\n" + "2: BubbleSort\n" + "3: MergeSort and BubbleSort\n" +
					"Please enter 1, 2, or 3:");
			choice = scanner.nextInt();
			if (choice == 1 || choice == 3) {
				startTime = System.currentTimeMillis();
				if (arrayLength <= 10) Sort.printArray(arrayList);
				Sort.mergeSort(arrayList);
				if (arrayLength <= 10) Sort.printArray(arrayList);
				System.out.printf("Merge sort an integer array of length %d is %.2f s\n",
						arrayLength, (System.currentTimeMillis() - startTime) / 1000.0);
				System.out.println("The sorted array is in correct order: " + Sort.isSorted(arrayList));
			}
			if (choice == 2 || choice == 3) {
				startTime = System.currentTimeMillis();
				if (arrayLength <= 10) Sort.printArray(copyArrayList);
				Sort.bubbleSort(copyArrayList);
				if (arrayLength <= 10) Sort.printArray(copyArrayList);
				System.out.printf("Bubble sort an integer array of length %d is %.2f s\n",
						arrayLength, (System.currentTimeMillis() - startTime) / 1000.0);
				System.out.println("The sorted array is in correct order: " + Sort.isSorted(copyArrayList));
			}
			System.out.println("\n" + "Continue? Please enter yes or no:");
			String yesNo = scanner.next();
			if (yesNo.equals("no"))
				break;
		}
		scanner.close();
		System.out.println("Goodbye!");
	}
}
