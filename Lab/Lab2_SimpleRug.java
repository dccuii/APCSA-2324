package Lab;
// Sep 22

class Lab2_SimpleRug {
  public static void main(String[] args) {
    
    int rugSize = 10;
    char [][] rug = new char [rugSize][rugSize];
    
    // Border
    for (int i = 0; i < rugSize; i++) {
      for (int j = 0; j < rugSize; j++) {
        rug[i][j] = '#';
      }
    }
    // empty inside
    for (int i = 1; i < rugSize-1; i++) {
      for (int j = 1; j < rugSize-1; j++) {
        rug[i][j] = ' ';
      }
    }
    
    // top left corner
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3 - i; j++) {
        rug[1+i][1+j] = 'O';
      }
    }

    // top right corner
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3 - i; j++) {
        rug[1+i][rugSize-2-j] = 'O';
      }
    }
    
    // bottom right corner
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3 - i; j++) {
        rug[rugSize-2-i][rugSize-2-j] = 'O';
      }
    }
    
    // bottom left corner
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3 - i; j++) {
        rug[rugSize-2-i][1+j] = 'O';
      }
    }
    
    // center square
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        rug[3+i][3+j] = '+';
      }
    }
    
    // print out rug 
    for (int i = 0; i < rugSize; i++) {
      for (int j = 0; j < rugSize; j++) {
        System.out.print(rug[i][j]);
      }
      System.out.println();
    }
    
    
    
  }
}
