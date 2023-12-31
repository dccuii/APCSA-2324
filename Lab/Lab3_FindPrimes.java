package Lab;
import java.util.Scanner;

class Lab3_FindPrimes {
  
  static Scanner s = new Scanner(System.in);
  
  public static void main(String[] args) {
    
    // ask for how many primes to find
    System.out.println("How many prime numbers do you want to find?");
    final int NUM_OF_PRIMES = getPositiveNumber();
    
    // initialize variables that we will use
    int numPrimesFound = 0; // count of how many primes we've found so far
    int [] primeArr = new int[NUM_OF_PRIMES]; // storing the primes
    int testNumber = 2; // start testing from the number 2
    
    // find the primes
    while (numPrimesFound < NUM_OF_PRIMES) {
      // while we haven't found all primes yet...
      // test for prime, and put it in the array if it is
      if (isNumberPrime(testNumber, primeArr, numPrimesFound)) primeArr[numPrimesFound++] = testNumber;
      testNumber++; // increment the test number
    }
    
    // print the primes
    printPrimesNeat(primeArr);
    
  }
  
  
  // user input and data validation for a positive number
  public static int getPositiveNumber() {
    int ret = -1; // initialize return variable
    while (ret < 0) {
      try {
        // data validation to make sure it's a positive integer
        System.out.println("Enter a non-negative integer.");
        ret = Integer.parseInt(s.nextLine());
        if (ret < 0) throw new Exception("neg number");
      } catch (Exception e) {
        System.out.println("That's not a valid input.");
      }
    }
    return ret;
  }
  
  
  // checks if the inputted number is prime
  public static boolean	isNumberPrime(int num, int [] primeArr, int numFound) {
    // there's a way to optimize this line specifically :^)
    for (int i = 0; i < numFound; i++) { 
      // if we have no remainder, then it is divisible by something
      if (num % primeArr[i] == 0) return false;
    }
    return true; // if nothing was divisible, it's prime
  }
  
  
  // print the primes in a neat format
  public static void printPrimesNeat(int [] arr) {
    // this integer keeps the max length of the items in the array
    int maxLen = Integer.toString(arr[arr.length-1]).length();
    
   	// making the tag for printf. left indented, with standardized width
    // thank you to whoever showed me this o7
    String tag = "%-" + maxLen + "d"; 
    
    // print
    System.out.println("Your prime numbers are: ");
    for (int i = 0; i < arr.length; i++) {
      System.out.printf(tag + "  ", arr[i]);
      
      // print out 10 items each line
      if (i % 10 == 9) System.out.println();
    }
  }
}

