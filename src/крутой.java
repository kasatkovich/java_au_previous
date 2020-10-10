import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int numNonOverlapping = 1;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int endHolder = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] >= endHolder) {
                numNonOverlapping++;
                endHolder = interval[1];
            }
        }
        return intervals.length - numNonOverlapping;
    }
}