package easy;

import java.util.*;

//https://leetcode.com/problems/logger-rate-limiter/
public class Logger {
    LinkedHashMap<String, Integer> map = null;
    private final int allowabletime = 10;
    /** Initialize your data structure here. */
    public Logger() {
        map = new LinkedHashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            int allowed = map.get(message);
            if(timestamp < allowed) return false;
            map.put(message, timestamp+allowabletime);
            return true;
        }else{
            map.put(message, timestamp+allowabletime);
            return true;
        }

    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */