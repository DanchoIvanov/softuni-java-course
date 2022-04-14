package shapes;

public abstract class Shape {

    private double perimeter;
    private double area;

    abstract public double calculatePerimeter();
    abstract public double calculateArea();

    public double getPerimeter() {
        return perimeter;
    }

    private void setPerimeter(double perimeter) {
        this.perimeter = calculatePerimeter();
    }

    public double getArea() {
        return area;
    }

    private void setArea(double area) {
        this.area = calculateArea();
    }
}
