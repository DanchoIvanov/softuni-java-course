package shapes;

public class Rectangle extends Shape {

    private double height;
    private double width;

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    public Rectangle(double height, double width) {
        this.setHeight(height);
        this.setWidth(width);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * height + 2 * width;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }
}
