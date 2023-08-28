import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private double limit;
    private double balance;
    private List<Purchase> purchaseList;

    public CreditCard(double limit) {
        this.limit = limit;
        this.balance = limit;
        this.purchaseList = new ArrayList<>();
    }

    public boolean buy (Purchase purchase){
        if (purchase.getPrice() > this.balance){
            return false;
        } else {
            this.balance -= purchase.getPrice();
            this.purchaseList.add(purchase);
            return true;
        }

    }

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }
}
