package designpattern.template;

import java.util.function.Consumer;

public class LocalBanking extends AbstractBanking {

    public void makeCustomerHappy(Customer c) {
        System.out.println("MAKE Customer happy");
    }
}