/**
 * Implementation of InsertionSort
 */
public class InsertionSort {
  public static void sort(int A[], int n) {
    int j;
    int element;
    for (int i = 1; i < n; i++) {
      j = i - 1; //the position one step below the i.
      element = A[i]; //the element which will insert to the already sorted array.
      while (j >= 0 && A[j] >= element) { // use half swap to find the correct position for element.
        A[j+1] = A[j];
        j = j - 1;
      }
      A[j+1] = element; //insert the element in the position.
    }
  }

  public static void main(String args[]) {
    int A[] = {1,2,8,-99,34,231,37,10,-9,-32};
    InsertionSort.sort(A, 10);
    for (int i = 0; i < 10; i++) {
      System.out.println(A[i]);
    }
  }
}
