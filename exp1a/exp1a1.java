interface Shape {
    double calculateArea();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    public double calculateArea() {
        return 0.5f*base*height;
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return 3.14f*radius*radius;
    }
}

public class exp1a1 {
    public static void main(String[] args) {
        Shape rect = new Rectangle(5, 10);
        Shape tri = new Triangle(4, 6);
        Shape circ = new Circle(7);

        System.out.println("Rectangle area: " + rect.calculateArea());
        System.out.println("Triangle area: " + tri.calculateArea());
        System.out.println("Circle area: " + circ.calculateArea());
    }
}
