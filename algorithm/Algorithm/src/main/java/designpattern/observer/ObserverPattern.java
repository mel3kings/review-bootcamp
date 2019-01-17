package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern implements Observer {
    private List<Broadcaster> broadcasterList = new ArrayList<>();

    @Override
    public void registerBroadcaster(Broadcaster b) {
        broadcasterList.add(b);
    }

    @Override
    public void notifyBroadcaster(String news) {
        broadcasterList.forEach(b -> b.receiveNews(news));
    }
}
