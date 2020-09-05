package structural.facade;


import javax.swing.*;
import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

class Buffer{
    private char [] characters;
    private int lineWidth;

    public Buffer(int lineHeight, int lineWidth){
        this.lineWidth = lineWidth;
        characters = new char[lineWidth*lineHeight];
    }

    public char charAt(int x, int y){
        return characters[y*lineWidth+x];
    }
}

class ViewPort{

    private final Buffer buffer;
    private final int width;
    private final int height;
    private final int offsetX;
    private final int offsetY;

    public ViewPort(Buffer buffer, int width, int height
                    , int offsetX, int offsetY) {
        this.buffer = buffer;
        this.width = width;
        this.height = height;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public char charAt(int x, int y){
        return buffer.charAt(x+offsetX, y+offsetY);
    }
}

// Console
class Console{
    private List<ViewPort> viewPorts = new ArrayList<>();
    int width, height;

    public Console(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addViewPort(ViewPort viewPort){
        viewPorts.add(viewPort);
    }

    // 이와 같이 내부적으로 전체를 알아서 구현을 해놓으면 동작하도록 만들 수 있다.
    public static Console newConsole(int width, int height){
        Buffer buffer = new Buffer(width, height);
        ViewPort viewPort = new ViewPort(buffer, width, height, 0 , 0);
        Console console = new Console(width, height);
        console.addViewPort(viewPort);
        return console;
    }

    public void render(){
        for(int y=0; y < height; ++y){
            for(int x = 0; x < width; ++x){
                for(ViewPort vp : viewPorts){
                    System.out.print(vp.charAt(x, y));
                }
            }

            System.out.println();
        }
    }
}

public class FacadeExample {
    public static void main(String[] args){
        Buffer buffer = new Buffer(30 ,20);
        ViewPort viewPort = new ViewPort(buffer, 30, 20, 0, 0);
        Console console = new Console(30, 20);
        console.addViewPort(viewPort);
        console.render();

        Console console2 = Console.newConsole(30, 20);
        console2.render();
    }
}
