package com.kxw.mapred;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * 把某类bean看成相同的bean
 * 实现分组后的排序
 * Created by kangxiongwei on 2017/5/28.
 */
public class GroupCombiner extends WritableComparator {

    public GroupCombiner() {
        //必须要有
        super(ProductOrderBean.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        ProductOrderBean x = (ProductOrderBean) a;
        ProductOrderBean y = (ProductOrderBean) b;
        return x.getPid().compareTo(y.getPid());
    }
}
