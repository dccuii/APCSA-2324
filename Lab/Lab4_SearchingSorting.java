package Lab;
import java.util.*;

class Lab4_SearchingSorting {
  public static void main(String[] args) {
    int [] arr = initRandomArray(10);
    System.out.println("Initial array: ");
    System.out.println(Arrays.toString(arr));
    
    // Sorting
    System.out.println("\n=============================\nSorting" +
                       "\n=============================");
    
    // selectionSort(arr); 
    bubbleSort(arr);
    // insertionSort(arr);
    
    System.out.println("After sorting: ");
    System.out.println(Arrays.toString(arr));
    
    
    // Searching
    System.out.println("\n=============================\nSearching" +
                       "\n=============================");
    
    int targetIdx = 5;
    int target = arr[targetIdx];
    //arr[targetIdx+1] = target+1;
    
    // Linear search 
    int linIdx1 = linearSearch(arr, target), linIdx2 = linearSearch(arr, target+1);
    if (linIdx1 < 0) {
      System.out.printf("Linear: %d is not in arr.%n", target);
    } else {
      System.out.printf("Linear: %d is at index %d of arr.%n", target, linIdx1);
    }
    if (linIdx2 < 0) {
      System.out.printf("Linear: %d is not in arr.%n", target+1);
    } else {
      System.out.printf("Linear: %d is at index %d of arr.%n", target+1, linIdx2);
    }
    
    // Binary search
    
    int linIdx3 = binarySearch(arr, target), linIdx4 = binarySearch(arr, target+1);
    if (linIdx3 < 0) {
      System.out.printf("Binary: %d is not in arr.%n", target);
    } else {
      System.out.printf("Binary: %d is at index %d of arr.%n", target, linIdx3);
    }
    if (linIdx4 < 0) {
      System.out.printf("Binary: %d is not in arr.%n", target+1);
    } else {
      System.out.printf("Binary: %d is at index %d of arr.%n", target+1, linIdx4);
    } 
  }
  
  public static void insertionSort(int [] arr) {
    for (int toSort = 1; toSort < arr.length; toSort++) {
      int i = toSort, compare = toSort - 1;
      while (arr[i] < arr[compare]) {
        int temp = arr[compare];
        arr[compare] = arr[i];
        arr[i] = temp;
        if (compare == 0) {
          break;
        } else {
          i--; compare--;
        }
      }
    }
  }
  
  public static void bubbleSort(int [] arr) {
    for (int endOfCheck = arr.length-1; endOfCheck > 1; endOfCheck--) {
      for (int check = 0; check < endOfCheck; check++) {
        if (arr[check] > arr[check+1]) {
          int temp = arr[check];
          arr[check] = arr[check+1];
          arr[check+1] = temp;
        }
      }
    }
  }
  
  public static void selectionSort(int [] arr) {
    for (int swap = 0, minIdx = swap; swap < arr.length; swap++) {
      for (int check = swap+1; check < arr.length; check++) {
        if (arr[check] < arr[minIdx]) minIdx = check;
      }
      if (swap != minIdx) {
       int temp = arr[swap];
        arr[swap] = arr[minIdx];
        arr[minIdx] = temp; 
      }
    }
  }
  
  public static int linearSearch(int [] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) return i;
    }
    return -1;
  }
  
  public static int binarySearch(int [] arr, int target) {
    int a = 0, b = arr.length-1;
    while (a <= b) {
      int mid = (a + b) / 2;
      if (arr[mid] == target) { return mid;
      } else if (arr[mid] < target) { a = mid + 1;
      } else { b = mid - 1; }
    }
    return -1;
  }
  
  
  public static int [] initRandomArray(int len) {
    int [] arr = new int[len];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random()*100);
    }
    return arr;
  }
}
