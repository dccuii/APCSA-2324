package Lab;
import java.util.Scanner;

// Sep 15

class Lab1_DivBy345 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Please input a number: ");
    int x = s.nextInt();
    
    if (x % 5 == 0) {
      // DIV BY 5
      if ((x % 3 == 0) && (x % 4 == 0)) {
        System.out.println("This number is divisible by 3, 4, and 5.");
      } else if (x % 3 == 0) {
        System.out.println("This number is divisible by 3 and 5.");
      } else if (x % 4 == 0) {
        System.out.println("This number is divisible by 4 and 5.");
      } else {
        System.out.println("This number is divisible by 5.");
      }
    } else {
      // NOT DIV BY 5
      if ((x % 3 == 0) && (x % 4 == 0)) {
        System.out.println("This number is divisible by 3 and 4.");
      } else if (x % 3 == 0) {
        System.out.println("This number is divisible by 3.");
      } else if (x % 4 == 0) {
        System.out.println("This number is divisible by 4.");
      } else {
        System.out.println("This number is not divisible by 3, 4 or 5.");
      }
    } // end if div by 5
    
    s.close();
  }
}