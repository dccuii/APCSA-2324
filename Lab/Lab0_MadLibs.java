package Lab;
import java.util.Scanner;  // Import the Scanner class

class Lab0_MadLibs {
  public static void main(String[] args) {
    
	Scanner s = new Scanner(System.in);
    
    System.out.println("Enter a unit of time:");
    String time1 = s.nextLine();
    
    System.out.println("Enter a verb (present tense):");
    String verb1 = s.nextLine();
    
    System.out.println("Enter a place:");
    String place1 = s.nextLine();
    
    System.out.println("Enter an adjective:");
    String adj1 = s.nextLine();
    
    System.out.println("Enter a food ingredient:");
    String food1 = s.nextLine();
    
    System.out.println("Enter a unit of size:");
    String size1 = s.nextLine();
    
    System.out.println("Enter a food ingredient:");
    String food2 = s.nextLine();
    
    System.out.println("Enter a unit of time:");
    String time2 = s.nextLine();
    
    System.out.println("Enter a verb (past tense):");
    String verb2 = s.nextLine();
    
    System.out.println("Enter an adverb:");
    String adv1 = s.nextLine();
    
    System.out.println("Enter a verb (past tense):");
    String verb3 = s.nextLine();
    
    
    // =================================================================
    System.out.println("Your Madlibs is done!\n\n");
    // =================================================================
    
    
    System.out.println("Three " + time1 + " ago, I tried to " + verb1 + " some ice cream.");
    
    System.out.print("Unfortunately for me, the ice cream store at ");
    System.out.println(place1 + " was closed, so I had to get " + adj1 + ".");
    
    System.out.print("I bought some " + food1 + ", two " + size1);
    System.out.println(" of sugar, and some " + food2 + " extract and got to work.");
    
    System.out.println("After a couple " + time2 + ", I finished my homemade ice cream.");
    
    System.out.println("I " + verb2 + " myself a big bowl and " + adv1 + " " + verb3 + " it all.");
    
    s.close();
  }
}
