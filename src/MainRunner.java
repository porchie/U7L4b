public class MainRunner {
    public static void main(String[] args) {
        Address address = new Address("1313 Mockingbird Lane Apt 6A, Springfield, MO 11220");
        Address address2 = new Address("1313 Mockingbird Lane, Springfield, MO 13332");

        System.out.println(address);
        System.out.println(address2);

        Package pack = new Package(address,address2,5.6);
        System.out.println(PostageCalculator.calculatePostage(pack));

    }
}
