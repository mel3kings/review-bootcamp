package designpattern.observer;

public class NewYorkTimes implements Broadcaster {

    public void receiveNews(String news) {
        System.out.println("NYTimes has received: " + news);
    }
}
