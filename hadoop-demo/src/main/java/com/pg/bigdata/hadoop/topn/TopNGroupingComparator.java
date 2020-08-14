package com.pg.bigdata.hadoop.topn;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class TopNGroupingComparator extends WritableComparator {
    public TopNGroupingComparator() {
        super(TopNKey.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        TopNKey k1 = (TopNKey) a;
        TopNKey k2 = (TopNKey) b;
        //  按着 年，月分组
        int c1 = Integer.compare(k1.getYear(), k2.getYear());
        if (c1 == 0) {
            return Integer.compare(k1.getMonth(), k2.getMonth());
        }

        return c1;
    }
}
