package com.Arrays.problems;

import java.util.*;

/**
 * Created by rahul.pandey on 3/31/17.
 */

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {

    private static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0 && newInterval == null) return intervals;
        if (newInterval.start > newInterval.end) {
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }
        ArrayList<Interval> newIntervals = new ArrayList<Interval>();
        boolean intervalAdded = false;
        for (int i = 0; i < intervals.size(); i++) {
            int currentStart = intervals.get(i).start;
            int currentEnd = intervals.get(i).end;
            if (!intervalAdded && currentStart >= newInterval.start) {
                if (currentEnd < newInterval.end) {
                    i++;
                    while (i < intervals.size()) {
                        int futureStart = intervals.get(i).start;
                        int futureEnd = intervals.get(i).end;
                        if (newInterval.end > futureStart && newInterval.end <= futureEnd) {
                            Interval reformedInterval = new Interval(newInterval.start, futureEnd);
                            newIntervals.add(reformedInterval);
                            intervalAdded = true;
                            break;
                        } else if (i == intervals.size() - 1 && newInterval.end > futureEnd) {
                            Interval reformedInterval = new Interval(newInterval.start, newInterval.end);
                            newIntervals.add(reformedInterval);
                            intervalAdded = true;
                            break;
                        }
                        i++;
                    }

                } else if (currentStart > newInterval.end) {
                    intervalAdded = true;
                    newIntervals.add(new Interval(newInterval.start, newInterval.end));
                    newIntervals.add(intervals.get(i));
                } else if (currentEnd > newInterval.end) {
                    intervalAdded = true;
                    newIntervals.add(new Interval(newInterval.start, intervals.get(i).end));
                }
            } else if (!intervalAdded && currentStart < newInterval.start) {
                if (newInterval.start > currentEnd) {
                    newIntervals.add(intervals.get(i));
                } else if (newInterval.start < currentEnd && newInterval.end < currentEnd) intervalAdded = true;
                else if (newInterval.start < currentEnd && newInterval.end > currentEnd) {
                    i++;
                    while (i < intervals.size()) {
                        int futureStart = intervals.get(i).start;
                        int futureEnd = intervals.get(i).end;
                        if (newInterval.end > futureStart && newInterval.end < futureEnd) {
                            Interval reformedInterval = new Interval(currentStart, futureEnd);
                            newIntervals.add(reformedInterval);
                            intervalAdded = true;
                            break;
                        } else if (i == intervals.size() - 1 && newInterval.end > futureEnd) {
                            Interval reformedInterval = new Interval(futureStart, newInterval.end);
                            newIntervals.add(reformedInterval);
                            intervalAdded = true;
                            break;
                        }
                        i++;
                    }
                }
            } else {
                newIntervals.add(intervals.get(i));
            }
        }
        if (!intervalAdded)

        {
            if (intervals.size() > 0) {
                Interval endInterval = intervals.get(intervals.size() - 1);
                if (newInterval.start > endInterval.start && newInterval.end > endInterval.end) {
                    newIntervals.add(newInterval);
                }
            } else {
                newIntervals.add(newInterval);
            }

        }
        return newIntervals;
    }

    public static void main(String[] args) {

        Interval interval = new Interval(3, 6);
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(interval);
        intervals.add(new Interval(8, 10));
        //intervals.add(new Interval(87248431, 94675146));
        intervals = (insert(intervals, new Interval(1, 2)));
        for (Interval intervalD : intervals) {
            System.out.println(intervalD.start + " " + intervalD.end);
        }

    }

}
