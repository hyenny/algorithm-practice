package com.algorithm.sortandsearch;

import java.util.Arrays;

public class MeetingRoom {
    public static void main(String[] args) {
        MeetingRoom meetingRoom = new MeetingRoom();
        //int[][] intervals = {{5,10}, {16,20}, {0,30}};
        int[][] intervals = {{6,10}, {1,3}, {15,30}};
        System.out.println(meetingRoom.solve(intervals));
    }

    public boolean solve(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return true;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            if (end > start) {
                return false;
            }
            end = intervals[i][1];
        }
        return true;
    }
}
