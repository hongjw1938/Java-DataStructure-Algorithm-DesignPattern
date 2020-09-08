package principle;

public class LiscovSubstitutePrinciple {
    public static void main(String[] args){
        Rectangle rc = new Rectangle(2, 3);
        useIt(rc);

        Rectangle sq = new Square();
        sq.setHeight(10);
        sq.setWidth(5);
        useIt(sq);
    }

    static void useIt(Rectangle r){
        int width = r.getWidth();
        r.setHeight(10);

        // area should be width * 10;
        System.out.println(
                "Expectd area of " + (width * 10) +
                        ", and got " + r.getArea()
        );
    }

}

class Rectangle{
    protected int width, height;

    public Rectangle() { }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea(){ return width*height; }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public boolean isSquare(){
        return width == height;
    }
}

class Square extends Rectangle{
    public Square() { }

    public Square(int size){
        width = height = size;
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);

    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);

    }
}

class RectangleFactory{
    public static Rectangle newRectangle(int width, int height){
        return new Rectangle(width, height);
    }

    public static Rectangle newSquare(int size){
        return new Rectangle(size, size);
    }
}
