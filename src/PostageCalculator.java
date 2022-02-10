public class PostageCalculator {

    public static double calculatePostage(Package pack)
    {
       return calculatePostage(pack.getOrigin().getZip(),pack.getDest().getZip(), pack.getWeight(),(pack.getHeight())+ pack.getLength()+ pack.getWidth());
    }

    public static double calculatePostage(String origZip,String destZip,double weight,double combinedDimensions)
    {
        double price = 3.75;

        price += (weight>40) ? (0.05 * (40 * 10)) + (0.1 * ((weight-40) * 10))  :  0.05 * (weight * 10);


        double zipDiff = Math.abs(Integer.parseInt(origZip.substring(0,3)) -  Integer.parseInt(destZip.substring(0,3)));
        zipDiff /= 100;

        price += (combinedDimensions>36)?(combinedDimensions-36)*.1:0;

        price += zipDiff;
        return price;

    }
    public static double calculatePostage(Address a1,Address a2, double weight, double combinedDimensions)
    {
        return calculatePostage(a1.getZip(), a2.getZip(), weight,combinedDimensions);
    }
}
