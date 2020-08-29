package com.design_pattern.structural.bridge;


/*
Shape -> Circle, Square
Rendering -> Vector, Raster

VectorCircleRenderer, VectorSquareEnderer ..
위와 같이 2x2라면 4개의 class, 만약 5x3이라면 15개의 class가 필요할 것이다.
그래서 Bridge가 필요함
 */


interface Renderer{
    void renderCircle(float radius);
}

class VectorRenderer implements Renderer{
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle of radius " + radius);
    }
}

class RasterRenderer implements Renderer{
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing pixels for a circle of radius " + radius);
    }
}

abstract class Shape{
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
    public abstract void resize(float factor);
}

class Circle extends Shape{
    public float radius;

    // Google의 Framework를 사용하여 Renderer Dependency를 inject
//    @Inject
    public Circle(Renderer renderer) {
        super(renderer);
    }

    public Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }

    @Override
    public void resize(float factor) {
        radius += factor;
    }
}



public class Bridge {
    public static void main(String[] args){
        /*
        다음과 같이, Renderer와 Shape 부분을 각각 interface 들을 분리하여,
        Shape를 구현한 class가 Renderer의 객체를 받아 사용할 수 있도록 bridge로 연결결         */
        RasterRenderer raster = new RasterRenderer();
        VectorRenderer vector = new VectorRenderer();
        Circle circle = new Circle(vector, 5);
        circle.draw();
        circle.resize(2);
        circle.draw();

        // 구글 Framework 사용 시
//        Injector injector = Guice.createInjector(new ShapeModule());
//        Circle instance = injector.getInstance(Circle.class);
//        instance.radius = 3;
//        instance.draw();
//        instance.resize(2);
//        instance.draw();
    }
}

// 구글의 Framework를 사용하는 경우임.
//class ShapeModule extends AbstractModule{
//    protected void configure(){
//        bind(Renderer.class).to(VectorRenderer.class);
//    }
//}