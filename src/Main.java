import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter card limit: ");
        double limit = read.nextDouble();
        CreditCard creditCard = new CreditCard(limit);

        int exit = 1;
        while (exit != 0) {
            System.out.println("Enter purchase description:");
            String description = read.next();

            System.out.println("Enter purchase value:");
            double value = read.nextDouble();

            Purchase purchase = new Purchase(description, value);
            boolean purchaseMade = creditCard.buy(purchase);

            if (purchaseMade) {
                System.out.println("Purchase made!");
                System.out.println("Enter 0 to exit or 1 to continue");
                exit = read.nextInt();
            } else {
                System.out.println("Insufficient funds!");
                exit = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("PURCHASES MADE:\n");
        creditCard.getPurchaseList().sort(Comparator.comparing(Purchase::getPrice));
        for (Purchase c : creditCard.getPurchaseList()) {
            System.out.println(c.getDescription() + " - " + c.getPrice());
        }
        System.out.println("\n***********************");

        System.out.println("\nCard balance: " + creditCard.getBalance());
    }
}
