package Lab;

import java.util.*;

class Lab8_CaesarCipher {
  
  static Scanner s = new Scanner(System.in);
  
  public static void main(String[] args) {
        
    System.out.println("Would you like to (E)ncrypt or (D)ecrypt a message?");
  	boolean doEncrypt = getEorD().equals("E");
    
    System.out.println("Enter your shift value: ");
    int shift = getShift();
    
    System.out.println("Enter your message: ");
    String message = s.nextLine();
    
    System.out.printf("Your %s message is: %n%s%n", 
                      doEncrypt ? "encrypted" : "decrypted", 
                      shiftMessage(message, shift, doEncrypt));
    
    
    
  }
  
  public static String shiftMessage(String message, int shift, boolean doEncrypt) {
    StringBuilder sb = new StringBuilder();
    shift = doEncrypt ? shift : -shift;
    
    for (char c : message.toCharArray()) {
      if (!Character.isAlphabetic(c)) {
        sb.append(c);
      } else {
        int add;
        if (c >= 'a' && c <= 'z') {
          // lowercase
          add = (c - 'a' + shift) % 26; // which letter of alphabet, add the shift
          add = add < 0 ? add + 26 : add;
          add = 'a' + add; // make sure its in the alphabet range and put into unicode range
        } else {
          // uppercase
          add = (c - 'A' + shift) % 26; // which letter of alphabet, add the shift
          add = add < 0 ? add + 26 : add;
          add = 'A' + add; // make sure its in the alphabet range and put into unicode range
        }
        sb.append((char) add);
        
      }
    }
    
    return sb.toString();
  }
  
  public static int getShift() {
    int ret;
    while (true) {
      try {
        ret = Integer.parseInt(s.nextLine());
        if (ret > 25 || ret < -25) throw new Exception();
        return ret;
      } catch (Exception e) {
        System.out.println("That was not a valid input. Enter an integer between -25 and 25 inclusive to indicate the shift value: ");
      }
    }
  }
  
  
  public static String getEorD() {
    String ret = "";
    
    while (true) {
      ret = s.nextLine().trim();
      if (ret.equalsIgnoreCase("e") || ret.equalsIgnoreCase("d")) return ret;
      
      System.out.println("That is not a valid input. Enter (E) to encrypt a message or (D) to decrypt a message.");
    }
  }
}
