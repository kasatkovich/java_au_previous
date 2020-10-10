# Intervals
+ [Non-overlapping Intervals](#non-overlapping-intervals)
+ [Non-overlapping Intervals](#non-overlapping-intervals)

## Non-overlapping Intervals
https://leetcode.com/problems/non-overlapping-intervals/
```java

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
```
## Non-overlapping Intervals
https://leetcode.com/problems/non-overlapping-intervals/
```java

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

```
