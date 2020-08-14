package com.pg.bigdata.hadoop.topn;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;


public class TopNMain {
    public static void main(String[] args) throws Exception {
        //maptask
        Configuration configuration = new Configuration(true);

        //        conf.set("mapreduce.framework.name","local");
        configuration.set("mapreduce.app-submission.cross-platform", "true");

        String[] others = new GenericOptionsParser(configuration, args).getRemainingArgs();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(TopNMain.class);

        job.setJar("/hadoop-hdfs-1.0-0.1.jar");

        //cache file
        job.addCacheFile(new Path("/data/topn/dict/dict.txt").toUri());

        //input
        TextInputFormat.addInputPath(job, new Path(others[0]));

        //output
        Path outPath = new Path(others[1]);
        if (outPath.getFileSystem(configuration).exists(outPath)) {
            outPath.getFileSystem(configuration).delete(outPath, true);
        }
        TextOutputFormat.setOutputPath(job, outPath);


        //key
        //map
        job.setMapperClass(TopNMapper.class);
        job.setMapOutputKeyClass(TopNKey.class);
        job.setMapOutputValueClass(DoubleWritable.class);


        //partationer
        //partitioner  按  年，月  分区  -》  分区 > 分组  按 年分区！！！！！！
        //分区器潜台词：满足  相同的key获得相同的分区号就可以~！
        job.setPartitionerClass(TopNPartitioner.class);

        //sortcomparator
        //sortComparator  年，月，温度  且  温度倒序
        job.setSortComparatorClass(TopNSortComparator.class);
        //combine
        //TODO
//        job.setCombinerClass(TopNCombiner.class);

        //reducetask

        //groupingcomparator
        job.setGroupingComparatorClass(TopNGroupingComparator.class);
        //reduce
        job.setReducerClass(TopNReduce.class);


        boolean finishFlag = job.waitForCompletion(true);
        if (finishFlag) {
            System.exit(finishFlag ? 0 : 1);
        }
    }
}
