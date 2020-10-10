# Intervals
+ [Non-overlapping Intervals](#non-overlapping-intervals)
+ [Merge-Intervals](#merge-intervals)

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
## Merge Intervals
https://leetcode.com/problems/merge-intervals/
```java
private class IntervalComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return a[0] < b[0] ? -1: a[0] == b[0] ? 0 : 1;
        }
    }
    public int[][] merge(int[][] intervals) {
        if (intervals == null)
            return intervals;
        LinkedList<int[]> heap = new LinkedList<>();
        Collections.sort(Arrays.asList(intervals),new IntervalComparator());
        for (int[] interval : intervals) {
            if (heap.isEmpty() || heap.getLast()[1] < interval[0])
                heap.add(interval);
            else if (interval[1] >= heap.getLast()[1])
                heap.getLast()[1] = interval[1];
        }
        return heap.toArray(new int[heap.size()][]);
    }
}
```
