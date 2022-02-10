import java.awt.*;

public class Package {
    private Address origin;
    private Address dest;
    private double weight;
    private double height;
    private double length;
    private double width;

    public Package(Address origin,Address dest, double weight,double length,double width, double height)
    {
        this.dest=dest;
        this.origin=origin;
        this.weight=weight;

        if (weight<0.1) weight = 0.1;
        this.length=length;
        this.width=width;
        this.height=height;

    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public Address getDest() {
        return dest;
    }

    public Address getOrigin() {
        return origin;
    }
}
