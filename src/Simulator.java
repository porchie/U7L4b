import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Simulator {


    public static Address randomAddress() throws FileNotFoundException
    {
        int streetNum = (int)(Math.random() * 2000) + 1;
        String streetName = randomStreetName();
        String[] stateAndZip = randomZipNState();

        Address address = new Address(streetNum + "",streetName,"-1","Springfield",stateAndZip[0],Integer.parseInt(stateAndZip[1]));
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

        String[] stateZip = {stateAndRange[0], "" + randomZip};
        sc.close();
        return stateZip;
    }
}