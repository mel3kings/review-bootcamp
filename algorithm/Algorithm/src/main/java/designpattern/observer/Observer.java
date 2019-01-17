package designpattern.observer;

public interface Observer {

    void registerBroadcaster(Broadcaster b);

    void notifyBroadcaster(String news);
}
