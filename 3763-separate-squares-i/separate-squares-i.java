class Solution {
    public double separateSquares(int[][] squares) {
        List<long[]> events = new ArrayList<>();
        long total = 0;

        for (int[] sq : squares) {
            long y = sq[1];
            long s = sq[2];
            long area = s * s;

            total += area;
            events.add(new long[]{y, s});
            events.add(new long[]{y + s, -s});
        }

        events.sort(Comparator.comparingLong(a -> a[0]));

        long currWidth = 0;
        long accumulated = 0;

        for (int i = 0; i + 1 < events.size(); i++) {
            currWidth += events.get(i)[1];
            long y1 = events.get(i)[0];
            long y2 = events.get(i + 1)[0];

            long stripArea = currWidth * (y2 - y1);

            if ((accumulated + stripArea) * 2 >= total) {
                long remaining = total - accumulated * 2;
                return y1 + (double) remaining / (2.0 * currWidth);
            }

            accumulated += stripArea;
        }

        return events.get(events.size() - 1)[0];
    }
}
