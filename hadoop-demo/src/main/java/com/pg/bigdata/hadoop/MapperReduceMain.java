package com.pg.bigdata.hadoop;

import com.pg.bigdata.hadoop.mr.MyMapper;
import com.pg.bigdata.hadoop.mr.MyReduce;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


public class MapperReduceMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration(true);

        System.out.println("---------start");
        Job job = Job.getInstance(conf);
        job.setJarByClass(MapperReduceMain.class);


        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);


        job.setReducerClass(MyReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);


        FileInputFormat.setInputPaths(job, args[0]);


        Path output = new Path(args[1]);
        FileSystem fileSystem = output.getFileSystem(conf);
        fileSystem.exists(output);
        if (fileSystem.exists(output)) {
            fileSystem.delete(output, true);
        }


        FileOutputFormat.setOutputPath(job, output);
        boolean b = job.waitForCompletion(true);
        System.out.println("---------end");
        System.exit(b ? 0 : 1);

    }
}
