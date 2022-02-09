public class Package {
    private Address origin;
    private Address dest;
    private double weight;

    public Package(Address origin,Address dest, double weight)
    {
        this.dest=dest;
        this.origin=origin;
        this.weight=weight;

        if (weight<0.1) weight = 0.1;
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
