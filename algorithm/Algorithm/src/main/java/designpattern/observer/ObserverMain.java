package designpattern.observer;

public class ObserverMain {

    public static void main(String[] args){
        ObserverPattern p = new ObserverPattern();
        p.registerBroadcaster(new NewYorkTimes());
        p.registerBroadcaster(new MorningHerald());
        p.registerBroadcaster((s) -> System.out.println("LAMBDA NEWS!! " + s));

        p.notifyBroadcaster("Design patterns are in Java 8!");
    }
}
