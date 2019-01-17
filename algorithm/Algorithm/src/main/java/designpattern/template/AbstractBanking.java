package designpattern.template;

import java.util.function.Consumer;

public abstract class AbstractBanking {

    public void doBanking(int id) {
        Customer customer = new Customer(id);
        System.out.println("did something complicated for banking");
        makeCustomerHappy(customer);
    }

    /**
     * This is needed so you can dynamically pass a cownsumer which is the same signature belo
     * @param id
     * @param makeCustomerHappy
     */
    public void doBanking(int id, Consumer<Customer> makeCustomerHappy) {
        Customer customer = new Customer(id);
        System.out.println("did something complicated for banking");
        makeCustomerHappy.accept(customer);
    }

    public abstract void makeCustomerHappy(Customer c);
}
