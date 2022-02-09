
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MainRunner {
    public static void main(String[] args) throws FileNotFoundException {


        Scanner sc = new Scanner(System.in);
        String choice = "";
        while(!choice.equals("q"))
        {

            System.out.println("Do you want to (s)imulate postages or (c)alculate your package's postage\n[Alternatively,(q) to quit the program]");

            choice = sc.nextLine();

            if(choice.equals("s"))
            {
                System.out.println("How many simulations?");
                int simNum = sc.nextInt();
                Simulator.simulate(simNum);
            }
            if(choice.equals("c"))
            {
                System.out.println("What is the origin address");
                String a1 = sc.nextLine();
                Address address1 = new Address(a1);
                System.out.println("What is the destination address");
                String a2 = sc.nextLine();
                Address address2 = new Address(a2);
                System.out.println("What is the weight of the package(lb)");
                double weight = sc.nextDouble();
                Package pack = new Package(address1,address2,weight);
                System.out.println("Price of Postage: " + PostageCalculator.calculatePostage(pack));
            }

        }

        sc.close();

    }


}
