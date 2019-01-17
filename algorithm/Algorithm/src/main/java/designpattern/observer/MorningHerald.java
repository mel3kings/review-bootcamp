package designpattern.observer;

public class MorningHerald implements Broadcaster {

    public void receiveNews(String news) {
        System.out.println("AU has received: " + news);
    }
}
