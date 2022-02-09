public class PostageCalculator {

    public static double calculatePostage(Package pack)
    {
       return calculatePostage(pack.getOrigin().getZip(),pack.getDest().getZip(), pack.getWeight());
    }

    public static double calculatePostage(String origZip,String destZip,double weight)
    {
        double price = 3.75;
        price += 0.05 * (weight * 10);

        double zipDiff = Math.abs(Integer.parseInt(origZip.substring(0,3)) -  Integer.parseInt(destZip.substring(0,3)));
        zipDiff /= 100;

        price += zipDiff;
        return price;

    }
    public static double calculatePostage(Address a1,Address a2, double weight)
    {
        return calculatePostage(a1.getZip(), a2.getZip(), weight);
    }
}
