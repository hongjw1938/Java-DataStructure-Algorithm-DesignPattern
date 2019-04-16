package com.designPattern.structural.decorator;


import java.util.function.Supplier;

class Circle2 implements Shape{
    private float radius;
    public Circle2(){

    }

    public Circle2(float radius) {
        this.radius = radius;
    }

    void resize(float factor){
        radius *= factor;
    }

    @Override
    public String info() {
        return "A circle of radius " + radius;
    }
}

class Square2 implements Shape{
    private float side;

    public Square2(){

    }
    public Square2(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return null;
    }
}

class TransparentShape2<T extends Shape> implements Shape{
    private Shape shape;
    private int transparency;

    public TransparentShape2(Supplier<? extends T> ctor, int transparency) {
        shape = ctor.get();
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape.info() + " has "
                + transparency + "% transparency";
    }
}

class ColoredShape2<T extends Shape> implements Shape{
    private Shape shape;
    private String color;

    public ColoredShape2(Supplier<? extends T> ctor, String color){
        shape = ctor.get();
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}
public class StaticDecorator {
    public static void main(String[] args){
        ColoredShape2<Square> blueSquare =
                new ColoredShape2<>(
                        () -> new Square(20),
                        "blue"
                );
        System.out.println(blueSquare.info());

        TransparentShape2<ColoredShape2<Circle>> myCircle =
                new TransparentShape2<>(
                        () -> new ColoredShape2<>(() -> new Circle(5), "green"), 50
                );
        System.out.println(myCircle.info());
    }
}
