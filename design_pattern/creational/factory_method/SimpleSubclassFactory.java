package creational.factory_method;

/*
    SimpleFactoryPatter의 예시에서는 직접 method를 객체 내부에 포함시키는 방법을 사용했으나, 실제로는
    별도의 Class로 구분하여 Factory Method만 Group화 하여 유지 보수에 용이하고 가독성이 있도록 코드를
    작성하는 경우가 많다.

    아래에서는 그러한 예시를 살펴본다.
*/

class Point2{
    private double x, y;

    private Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*
        다음과 같이 static 내부 class로 만들어서 private으로 생성자를 유지하여 사용할 수 있다.
    */
    public static class Factory{
        public static Point2 newCartesianPoint(int x, int y){
            return new Point2(x, y);
        }
        public static Point2 newPolarPoint(int rho, int theta){
            return new Point2(rho, theta);
        }
    }
}

/*
    아래와 같은 방식을 사용하면 객체 Class의 생성자를 Public으로 유지해야 한다는 문제가 생길 수 있다.
    혹은 그 자체가 이점일 수 있기에 이 방식도 활용할 수 있다.
class PointFactory{
    public static Point2 newCartesianPoint(int x, int y){
        return new Point2(x, y);
    }
    public static Point2 newPolarPoint(int rho, int theta){
        return new Point2(rho, theta)
    }
}
*/

public class SimpleSubclassFactory {
    Point2 point = Point2.Factory.newCartesianPoint(2, 3);
}
