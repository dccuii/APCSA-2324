package Lab;

import java.util.*;

class Lab6_7_RoomsForLevel {
  
  private static Scanner s = new Scanner(System.in);
  
  public static void main(String[] args) {    
    Room curr = initGame();
    
    System.out.println("Welcome to the puzzle rooms.");
    System.out.println("Press enter to start.");
    s.nextLine();
    
    String input = "";
    while (!input.equals("exit")) {
      System.out.println("\n========================================================\n");
      curr.displayRoom();
      curr.printActions();
      
      System.out.println("\nWhat would you like to do?");
      input = validateInput(curr);
      
      if (input.equals("next")) {
        curr = curr.getNext();
      } else if (input.equals("previous")) {
        curr = curr.getPrev();
      } else if (input.equals("unlock")) {
        unlockNextRoom(curr);
      }
      
    }
    
    System.out.println("Thanks for playing! You win!!!!DLD:DD:D:DDDDDDDDDD");
  }
  
  static void unlockNextRoom(Room r) {
    PuzzleRoom next = (PuzzleRoom) r.getNext();
    System.out.println("The room in front of you has a riddle for you to solve: " + next.getPuzzle());
    System.out.print("Your answer is: ");
    try {
      int input = Integer.parseInt(s.nextLine());
      if (next.getAnswer() != input) { 
        throw new Exception(); 
      } else {
        System.out.println("You hear a click, and the lock crumbles away into a fine dust.");
        next.unlock();
      }
    } catch (Exception e) {
      System.out.println("The lock doesn't budge. You seemed to have gotten the puzzle wrong...");
    } 
    System.out.println("Press enter to continue.");
    s.nextLine();
  }
  
  static String validateInput(Room r) {
    String input;
    while (true) {
      input = s.nextLine();
      if (validInput(r, input)) return input;
      System.out.println("That is not a valid input.");
      r.printActions();
    }
  }
  
  static boolean validInput(Room r, String input) {
    for (String x : r.getValidActions()) {
      if (input.equals(x)) return true;
    }
    return false;
  }
  
  static Room initGame() {
    Room spawn = new SpawnRoom();
    Room p1 = new PuzzleRoom("4+5", 9);
    Room p2 = new PuzzleRoom("4*5", 20);
    Room goal = new GoalRoom();
    
    spawn.setNext(p1);
    
    p1.setNext(p2);
    p1.setPrev(spawn);
    
    p2.setNext(goal);
    p2.setPrev(p1);
    
    goal.setPrev(p2);
    
    return spawn;
  }
}


abstract class Room {
  private String name;
  private Room next;
  private Room prev; 
  private boolean unlocked;
  private String [] validActions;
  
  Room(String name, boolean unlocked, String [] validActions) {
    this.name = name;
    this.unlocked = unlocked;
    this.validActions = validActions;
  }
  
  public String getName() { return this.name; }
  public Room getNext() { return this.next; }
  public Room getPrev() { return this.prev; }
  public boolean isUnlocked() { return this.unlocked; }
  public String [] getValidActions() { 
    
    if (this.next == null || this.next.unlocked) {
      return this.validActions;
    }
    
    String [] ret = new String[this.validActions.length + 1];
    for (int i = 0; i < this.validActions.length; i++) {
      ret[i] = this.validActions[i].equals("next") ? "unlock" : this.validActions[i];
    }
    return ret; 
  }
  
  public void setNext(Room r) { this.next = r; }
  public void setPrev(Room r) { this.prev = r; }
  public void unlock() { this.unlocked = true; }
  
  
  
  abstract public void displayRoom();
  
  public void printActions() {
    if (this instanceof GoalRoom) {
      System.out.println("You may [exit] to finish the game!");
    }
    
    if (this.next != null) {
      if (this.next.unlocked) {
        System.out.printf("You may enter into the [next] %s. %n", this.next.getName());
      } else {
        System.out.printf("You can try to [unlock] the next %s. %n", this.next.getName());
      }
    }
    
    if (this.prev != null)
      System.out.printf("You may go back to the [previous] %s. %n", this.prev.getName());
  }
}

class SpawnRoom extends Room {
  
  SpawnRoom() { super("spawn room", true, new String [] {"next", "unlock"}); }
  
  public void displayRoom() {
    System.out.println("You feel a sense of familiarity and safety: you're in the spawn room.");
    if (this.getNext() != null) {
      System.out.printf("In front of you, you see a(n) %s %s. %n", 
                        this.getNext().isUnlocked() ? "unlocked" : "locked", 
                        this.getNext().getName());
    } else { System.out.println("There is nothing in front of you."); }
  }
  
  
  
}

class PuzzleRoom extends Room {
  private String puzzle; 
  private int answer;
  
  PuzzleRoom(String puzzle, int answer) {
    super("puzzle room", false, new String [] {"next", "previous"});
    this.puzzle = puzzle;
    this.answer = answer;
  }
  
  public String getPuzzle() { return this.puzzle; }
  public int getAnswer() { return this.answer; }
  
  public void displayRoom() {
    System.out.println("You're in a puzzle room."); 
    
    if (this.getNext() != null) {
      System.out.printf("In front of you, you see a(n) %s %s. %n", 
                        this.getNext().isUnlocked() ? "unlocked" : "locked", this.getNext().getName());
    } else { System.out.println("There is nothing in front of you. "); }

    if (this.getPrev() != null) {
      System.out.printf("Behind you, you see a(n) %s %s. %n", 
                        this.getPrev().isUnlocked() ? "unlocked" : "locked", this.getPrev().getName());
    } else { System.out.println("There is nothing behind you. "); }
  }
  
  
}

class GoalRoom extends Room {
  
  GoalRoom() { super("goal room", true, new String [] {"previous", "exit"}); }
  
  public void displayRoom() {
    System.out.println("You feel accomplished for finishing the puzzles. You can now exit."); 
    
    if (this.getPrev() != null) {
      System.out.printf("Behind you, you see a(n) %s %s. %n", 
                        this.getPrev().isUnlocked() ? "unlocked" : "locked", this.getPrev().getName());
    } else { System.out.println("There is nothing behind you. "); }
  }
}
 



