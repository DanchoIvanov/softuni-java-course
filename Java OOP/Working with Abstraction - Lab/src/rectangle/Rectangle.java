package rectangle;

public class Rectangle {
    private Point bottomLeftPoint;
    private Point topRightPoint;

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) {
        this.bottomLeftPoint = new Point(bottomLeftX, bottomLeftY);
        this.topRightPoint = new Point(topRightX, topRightY);
    }

    public Point getBottomLeftPoint() {
        return bottomLeftPoint;
    }

    public void setBottomLeftPoint(Point bottomLeftPoint) {
        this.bottomLeftPoint = bottomLeftPoint;
    }

    public Point getTopRightPoint() {
        return topRightPoint;
    }

    public void setTopRightPoint(Point topRightPoint) {
        this.topRightPoint = topRightPoint;
    }

    public boolean contains (int x, int y){
        return x >= bottomLeftPoint.getX() && x <= topRightPoint.getX() && y >= bottomLeftPoint.getY() && y <= topRightPoint.getY();
    }
}
