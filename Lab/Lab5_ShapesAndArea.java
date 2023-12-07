package Lab;
class Lab5_ShapesAndArea {
  public static void main(String[] args) {
    
    System.out.printf("The area of image 1 is %.3f%n", imageOne());
    System.out.printf("The area of image 2 is %.3f%n", imageTwo());
    System.out.printf("The area of image 3 is %.3f%n", imageThree());
    
  }
  
  public static double imageOne() { // 9
    double area = 0;
    
    // four semicircles
    area += (new Circle(1).getArea()) / 2;
    area += (new Circle(1).getArea()) / 2;
    area += (new Circle(1).getArea()) / 2;
    area += (new Circle(1).getArea()) / 2;
    
    // top and bottom rectangles
    area += new Rectangle(2, 10).getArea();
    area += new Rectangle(2, 10).getArea();
    
    // middle long rectangle
    area += new Rectangle(3, 14).getArea();
    
    // two removed triangles
    area += new Triangle(3, 3, true).getArea();
    area += new Triangle(3, 3, true).getArea();
    
    return area;
  }
  
  public static double imageTwo() { // 26
    double area = 0;
    
    // A - 6
    area += new Rectangle(7, 3).getArea();
    area += new Triangle(1, 1, true).getArea(); // two triangles at top
    area += new Triangle(1, 1, true).getArea();
    area += new Triangle(1, 1, true).getArea(); // triangle on hole
    area += new Rectangle(1, 1, true).getArea(); // square on hole
    area += new Rectangle(3, 1, true).getArea(); // remove long rectangle bottom
    
    // P - 5
    area += new Rectangle(7, 1).getArea(); // stick of P
    area += new Rectangle(4, 2).getArea(); // round of P
    area += new Triangle(1, 1, true).getArea(); // two corners of P
    area += new Triangle(1, 1, true).getArea();
    area += new Triangle(2, 1, true).getArea(); // hole of P
    
    
    // C - 8
    area += new Rectangle(7, 3).getArea();
    area += new Triangle(1, 1, true).getArea(); // four corners
    area += new Triangle(1, 1, true).getArea(); 
    area += new Triangle(1, 1, true).getArea(); 
    area += new Triangle(1, 1, true).getArea(); 
    area += new Rectangle(3, 2, true).getArea(); // main hole of C
    area += new Triangle(1, 1, true).getArea(); // hole upper triangle
    area += new Triangle(1, 1, true).getArea(); // hole lower triangle
    
    // S - 7
    area += new Rectangle(7, 3).getArea();
    area += new Triangle(2, 1, true).getArea(); // four corners
    area += new Triangle(2, 1, true).getArea();
    area += new Triangle(2, 1, true).getArea();
    area += new Triangle(2, 1, true).getArea();
    area += new Triangle(1.5, 1, true).getArea(); // two ends of S
    area += new Triangle(1.5, 1, true).getArea();
    
    return area;
  }
  
  public static double imageThree() {
    double area = 0;
    
    area += new Rectangle(7, 8).getArea(); // house 
    area += new Triangle(10, 4).getArea(); // roof

    area += new Rectangle (1.5, 1).getArea(); // chimney 
    area += new Triangle(1, 1).getArea();
    
    area += new Rectangle(1, 1, true).getArea(); // attic
    area += new Circle(.5).getArea();
    
    area += new Circle(.5).getArea(); // smoke
    area += new Circle(.75).getArea();
    area += new Circle(1).getArea();
    
    area += new Rectangle(2, 2, true).getArea(); // windows
    area += new Rectangle(2, 2, true).getArea();
    area += new Rectangle(3, 2, true).getArea(); // door
    area += new Circle(1.0/6).getArea(); // door handle
    
    
    return area;
  }
}

class Circle {
  private double radius;
  private double area;
  private boolean isNegativeSpace;
  
  Circle(double radius) {
    this(radius, false);
  }
  
  Circle(double radius, boolean isNegative) {
    this.radius = radius;
    this.area = Math.PI * this.radius * this.radius;
    this.isNegativeSpace = isNegative;
  }
  
  public double getArea() {
    return this.isNegativeSpace ? -1 * this.area : this.area;
  }  
}

class Rectangle {
  private double length;
  private double width;
  private double area;
  private boolean isNegativeSpace;
  
  Rectangle(double length, double width) {
    this(length, width, false);
  }
  
  Rectangle(double length, double width, boolean isNegative) {
    this.length = length;
    this.width = width;
    this.area = this.length * this.width;    
    this.isNegativeSpace = isNegative;
  }
  
  public double getArea() {
    return this.isNegativeSpace ? -1 * this.area : this.area;
  }
}

class Triangle {
  private double base;
  private double height;
  private double area;
  private boolean isNegativeSpace;
  
  Triangle(double base, double height) {
    this(base, height, false);
  }
  
  Triangle(double base, double height, boolean isNegative) {
    this.base = base;
    this.height = height;
    this.area = this.base * this.height / 2; 
    this.isNegativeSpace = isNegative;
  }
  
  public double getArea() {
    return this.isNegativeSpace ? -1 * this.area : this.area;
  }
}