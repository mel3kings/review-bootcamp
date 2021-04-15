package medium;

import java.util.*;

//https://leetcode.com/problems/meeting-rooms-ii/
public class MeetingRooms {
    List<List<Integer>> meetings = new ArrayList<>();

    public int minMeetingRooms(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int first = interval[0];
            int second = interval[1];
            int index = isOverLap(first, second);
            System.out.println("index is " + index + " " + first + " " + second);
            if (index == -1) {
                List<Integer> append = new ArrayList<>();
                append.add(first);
                append.add(second);
                meetings.add(append);
            } else {
                List<Integer> append = meetings.get(index);
                append.add(first);
                append.add(second);

            }
            System.out.println(meetings);
        }
        return meetings.size();
    }

    public int isOverLap(int start, int end) {
        for (int i = 0; i < meetings.size(); i++) {
            List<Integer> booked = meetings.get(i);
            for (int j = 0; j < booked.size(); j += 2) {

                int bookedStart = booked.get(j);
                int bookedEnd = booked.get(j + 1);

                int overLapStart = Math.max(bookedStart, start);
                int overLapEnd = Math.min(bookedEnd, end);
                if (overLapStart > overLapEnd) {
                    return i;
                }
                if (overLapStart <= bookedStart && overLapEnd >= end) {
                    return i;
                }
            }
        }
        return -1;


    }
    //0-10
    //2-5
    //2-5
}
