package sort;

import java.util.ArrayList;

public class Sort {

  public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> arrayList) {
    for (int i = arrayList.size() - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (arrayList.get(j).compareTo(arrayList.get(j+1)) > 0) {
          E temp = arrayList.get(j);
          arrayList.set(j, arrayList.get(j + 1));
          arrayList.set(j + 1, temp);
        }
      }
    }
  }

  public static <E extends Comparable<E>> void merge(ArrayList<E> arrayList, int start, int middle, int end) {
    int i = start, j = middle;
    ArrayList<E> tempArrayList = new ArrayList<>();
    while (i < middle && j < end) {
      if (arrayList.get(i).compareTo(arrayList.get(j)) < 0) {
        tempArrayList.add(arrayList.get(i));
        i ++;
      } else {
        tempArrayList.add(arrayList.get(j));
        j ++;
      }
    }
    while (i < middle) {
      tempArrayList.add(arrayList.get(i));
      i ++;;
    }
    while (j < end) {
      tempArrayList.add(arrayList.get(j));
      j ++;
    }
    for (E e : tempArrayList) {
      arrayList.set(start, e);
      start ++;
    }
  }

  public static <E extends Comparable<E>> void mergeSort(ArrayList<E> arrayList, int start, int end) {
    if (end - start <= 1) 
      return;
    int middle = (start + end) / 2;
    mergeSort(arrayList, start, middle);
    mergeSort(arrayList, middle, end);
    merge(arrayList, start, middle, end);
  }

  public static <E extends Comparable<E>> void mergeSort(ArrayList<E> arrayList) {
    mergeSort(arrayList, 0, arrayList.size());
  }

  public static <E extends Comparable<E>> boolean isSorted(ArrayList<E> arrayList) {
		for (int i = 0; i < arrayList.size() - 1; i++) {
			if (arrayList.get(i).compareTo(arrayList.get(i + 1)) > 0) {
				return false;
			}
		}
		return true;
	}

  public static <E> void printArray(ArrayList<E> arrayList) {
		for (E a : arrayList) {
			System.out.print(a + ", ");
		}
		System.out.println();
	}
}
