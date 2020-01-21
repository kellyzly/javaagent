package test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ATM {
    private static Logger LOGGER = LoggerFactory.getLogger(ATM.class);
    private  int total = 100;
    public void hi( ) {
        System.out.println("hi");
    }

    public  void withdrawMoney(int amount) throws InterruptedException {
        total = total -amount;
    }
}
