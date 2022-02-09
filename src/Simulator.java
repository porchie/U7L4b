import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Simulator {



    public static void simulate(int sims) throws FileNotFoundException
    {
        for(int i = 0;i<sims;i++)
        {
            Package pack = randomPackage();
            Address orig = pack.getOrigin();
            Address dest = pack.getDest();
            double weight = pack.getWeight();
            String price = String.format("$%.2f",PostageCalculator.calculatePostage(pack));
            System.out.println("Origin: " + orig.toString());
            System.out.println("Destination: " + dest.toString());
            System.out.println("Weight of item: " + String.format("%.2f", weight));
            System.out.println("Payment Due: " + price);
            System.out.println();
        }
    }

    public static Package randomPackage() throws FileNotFoundException
    {
        double rand = round(Math.random() * 150 + 1,1);
        Package pack = new Package(randomAddress(),randomAddress(),rand);
        return pack;
    }


    public static Address randomAddress() throws FileNotFoundException
    {
        int streetNum = (int)(Math.random() * 2000) + 1;
        String streetName = randomStreetName();
        String[] stateAndZip = randomZipNState();

        Address address = new Address(streetNum + "",streetName,"-1","Springfield",stateAndZip[0],stateAndZip[1]);
        return address;
    }

    public static String randomStreetName() throws FileNotFoundException {
        File file = new File("src/StreetNames");
        Scanner sc = new Scanner(file);

        int lineNum = (int)(Math.random()*100);
        for(int i = 0;i<lineNum;i++)
        {
            sc.nextLine();
        }
        String streetName = sc.nextLine();
        streetName = streetName.substring(streetName.indexOf(" ") +1);


        sc.close();
        return streetName;

    }

    public static String[] randomZipNState() throws FileNotFoundException
    {
        File file = new File("src/ZipAndState");
        Scanner sc = new Scanner(file);
        int lineNum = (int)(Math.random()*72);
        for(int i = 0;i<lineNum;i++)
        {
            sc.nextLine();
        }
        String str = sc.nextLine();
        String[] stateAndRange = str.split(" ");
        int min = Integer.parseInt(stateAndRange[1]);
        int max = Integer.parseInt(stateAndRange[2]);
        int randomZip = (int)(Math.random() *((max-min)+1)) + min;
        String randZip = String.format("%05d", randomZip);
        String[] stateZip = {stateAndRange[0], randZip};
        sc.close();
        return stateZip;
    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
