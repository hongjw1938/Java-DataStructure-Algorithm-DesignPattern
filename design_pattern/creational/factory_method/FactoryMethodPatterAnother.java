package creational.factory_method;

// 모든 비행기의 기본 구조를 갖는 추상 클래스
abstract class Plane{
    abstract void ride();
    abstract void getFeature();
}

//
class Jet extends Plane{
    @Override
    void ride() {
        System.out.println("제트기를 탔습니다 ^^");
    }

    @Override
    void getFeature() {
        System.out.println("무진장 빠르네요~~~~~~!");
    }
}

class UAV extends Plane{
    @Override
    void ride() {
        System.out.println("무인 항공기를 탔습니다 ^^");
    }

    @Override
    void getFeature() {
        System.out.println("으악 승무원이 없당 ㅠ");
    }
}

// 위는 각 비행기 객체를 정의한 클래스이다.

// 아래는 해당 비행기 객체를 받아오기 위한 Class들이다.
interface Airplane{
    Plane createPlane(String kind);
}

class AirplaneFactory implements Airplane{
    @Override
    public Plane createPlane(String kind) {
        Plane plane;
        switch (kind){
            case "jet":
            case "Jet":
            case "JET":
                return plane = getTicket("JET");
            case "uav":
            case "UAV":
                return plane = getTicket("UAV");
            default:
                System.out.println("적절한 값을 넣어야 해요");
                return null;
        }
    }

    private Plane getTicket(String kind) {
        System.out.println(kind + "의 티켓을 샀어요!");
        if(kind.equals("JET")){
            return new Jet();
        } else {
            return new UAV();
        }
    }
}

//아래는 조금 변경된 코드를 넣어 객체를 반환한다.
class ModifiedAirplaneFactory implements Airplane{

    @Override
    public Plane createPlane(String kind) {
        try{
            Class name = Class.forName(kind);
            Object plane = name.newInstance();

            return (Plane) plane;
        }catch(Exception e){
            return null;
        }

    }
}

public class FactoryMethodPatterAnother {

    public static void main(String[] args){
        Airplane plane = new AirplaneFactory();
        Plane p = plane.createPlane("JET");
        p.ride(); p.getFeature();

        Plane p2 = plane.createPlane("UAV");
        p2.ride(); p2.getFeature();

        Airplane plane2 = new ModifiedAirplaneFactory();
        Plane p3 = plane2.createPlane("com.designPattern.creational.factory.Jet");
        p3.ride(); p3.getFeature();

    }
}
