public class MainRunner {
    public static void main(String[] args) {
        Address address = new Address("1313 Mockingbird Lane Apt 6A, Springfield, MO 65123");
        Address address2 = new Address("1313 Mockingbird Lane, Springfield, MO 65123");

        System.out.println(address);
        System.out.println(address2);

    }
}
