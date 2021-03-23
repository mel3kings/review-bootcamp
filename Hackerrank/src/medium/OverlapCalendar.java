package medium;

import java.util.*;
//https://leetcode.com/problems/my-calendar-i/
public class OverlapCalendar {

    List<Entry> entries = null;
    public OverlapCalendar() {
        entries = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        Entry curr = new Entry(start, end);

        for (Entry existing : entries) {
            int st = Math.max(curr.start, existing.start);
            int ed = Math.min(curr.end, existing.end);
            if (st < ed) {
                return false;
            }
        }
        entries.add(curr);
        return true;
    }

    class Entry {
        int start;
        int end;

        public Entry(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

//["MyCalendar","book","book","book"]
//[[],[10,20],[15,25],[20,30]]
//["MyCalendar","book","book","book"]
//[[],[10,20],[40,200],[20,30]]
//["MyCalendar","book","book","book"]
//[[],[1,2],[3,4],[5,6]]
//["MyCalendar","book","book","book","book","book"]
//[[],[37,50],[33,50],[4,17],[35,48],[8,25]]
//["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
//[[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
