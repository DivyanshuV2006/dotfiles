public class DeliveryTest {
    public static void main(String[] args) {
        // Create two DeliveryPerson objects
        DeliveryPerson dp1 = new DeliveryPerson("Alex Johnson", 29, 40, 5.0);
        DeliveryPerson dp2 = new DeliveryPerson("Sarah Lee", 24, 30, 10.0);

        System.out.println("--- Delivery Person 1 ---");
        dp1.displayInfo();

        System.out.println();
        System.out.println("--- Delivery Person 2 ---");
        dp2.displayInfo();
    }
}
