package structural.adapter;

import java.util.*;
import java.util.function.Consumer;

class Point2
{
    public int x, y;

    public Point2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point2 point = (Point2) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode()
    {
        int result = x;
        result = 31 * result + y;
        return result;
    }
    @Override
    public String toString()
    {
        return "Point{" +
                "first=" + x +
                ", second=" + y +
                '}';
    }
}

class Line2
{
    public Point2 start, end;

    public Line2(Point2 start, Point2 end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line2 line = (Line2) o;

        if (!start.equals(line.start)) return false;
        return end.equals(line.end);
    }

    @Override
    public int hashCode()
    {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }

}

class VectorObject2 extends ArrayList<Line2> {}

class VectorRectangle2 extends VectorObject2
{
    public VectorRectangle2(int x, int y, int width, int height)
    {
        add(new Line2(new Point2(x,y), new Point2(x+width, y) ));
        add(new Line2(new Point2(x+width,y), new Point2(x+width, y+height) ));
        add(new Line2(new Point2(x,y), new Point2(x, y+height) ));
        add(new Line2(new Point2(x,y+height), new Point2(x+width, y+height) ));
    }
}

class LineToPointAdapter2 implements Iterable<Point2>
{

    private static int count = 0;
    private static Map<Integer, List<Point2>> cache = new HashMap<>();
    private int hash;

    public LineToPointAdapter2(Line2 line)
    {
        hash = line.hashCode();
        if(cache.get(hash) != null) return;

        System.out.println(
                String.format("%d: Generating points for line [%d,%d]-[%d,%d] (with caching)",
                        ++count, line.start.x, line.start.y, line.end.x, line.end.y));

        ArrayList<Point2> points = new ArrayList<>();


        int left = Math.min(line.start.x, line.end.x);
        int right = Math.max(line.start.x, line.end.x);
        int top = Math.min(line.start.y, line.end.y);
        int bottom = Math.max(line.start.y, line.end.y);
        int dx = right - left;
        int dy = line.end.y - line.start.y;

        if (dx == 0)
        {
            for (int y = top; y <= bottom; ++y)
            {
                points.add(new Point2(left, y));
            }
        }
        else if (dy == 0)
        {
            for (int x = left; x <= right; ++x)
            {
                points.add(new Point2(x, top));
            }
        }
        cache.put(hash, points);
    }

    @Override
    public Iterator<Point2> iterator()
    {
        return cache.get(hash).iterator();
    }

    @Override
    public void forEach(Consumer<? super Point2> action)
    {
        cache.get(hash).forEach(action);
    }

    @Override
    public Spliterator<Point2> spliterator()
    {
        return cache.get(hash).spliterator();
    }
}

public class AdapterCaching {
    /*
    NoCaching Class에서 보듯이, Line을 Point로 Adapt하기 위해 생성된 객체 내의 Line 마다
    Adapting을 시키면서 중복이 매우 빈번하게 일어나고 있다.

    그래서 Adapter 부분에 Caching 부분을 통해 이미 캐싱이 되어 있다면 더 이상 작업을 하지 않도록 지정할 수 있다.
     */
    private static final List<VectorObject2> vectorObjects =
            new ArrayList<>(Arrays.asList(
                    new VectorRectangle2(1,1,10,10),
                    new VectorRectangle2(3,3,6,6)
            ));

    public static void drawPoint(Point2 p)
    {
        System.out.print(".");
    }

    private static void draw()
    {
        for (VectorObject2 vo : vectorObjects)
        {
            for (Line2 line : vo)
            {
                LineToPointAdapter2 adapter = new LineToPointAdapter2(line);
                adapter.forEach(point -> drawPoint(point));
            }
        }
    }

    public static void main(String[] args)
    {
        draw();
        draw();
    }
}
