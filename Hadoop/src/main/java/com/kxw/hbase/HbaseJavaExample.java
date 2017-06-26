package com.kxw.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;

/**
 * Created by kangxiongwei on 2017/6/22.
 */
public class HbaseJavaExample {

    public static void main(String[] args) throws IOException {

        Configuration conf = HBaseConfiguration.create();

        conf.set("hbase.zookeeper.quorum", "mini1");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        conf.set("hbase.rootdir", "hdfs://mini1:9000/hbase");

        HBaseAdmin admin = new HBaseAdmin(conf);
        //定义表和列族
        HTableDescriptor htd = new HTableDescriptor(TableName.valueOf("test01"));
        HColumnDescriptor hcd = new HColumnDescriptor("data");
        htd.addFamily(hcd);
        //创建表
        admin.createTable(htd);

    }


}
