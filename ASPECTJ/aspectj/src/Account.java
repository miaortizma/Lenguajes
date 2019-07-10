import java.util.Base64;

public class Account {
    int balance = 10;


    public boolean withdraw(int amount) {
        if (balance < amount) {
            return false;
        }
        balance = balance - amount;
        return true;
    }

}