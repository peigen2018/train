package com.pg.bigdata.hadoop;

import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;


public class HadoopTests {

    private Configuration conf = null;

    private FileSystem fs = null;


    @Before
    public void before() throws Exception {
        conf = new Configuration(true);
        URI uri = new URI("hdfs://master:9000");
        fs = FileSystem.get(uri, conf, "god");
        System.out.println("before");
    }


    @Test
    public void mkdir() throws Exception {

        Path path = new Path("/tmp");
        if (fs.exists(path)) {
            System.out.println(fs.delete(path, true));
        }
        fs.mkdirs(path);
    }

    @Test
    public void update() throws Exception {


        Path path = new Path("/tmp/uploadFile.txt");
        FileInputStream inputStream = new FileInputStream("E:/project/github/hadoop/src/main/resources/data/uploadFile.txt");
        FSDataOutputStream outputStream = fs.create(path);
        IOUtils.copyBytes(inputStream, outputStream, conf, true);

    }

    @Test
    public void download() throws Exception {
        Path path = new Path("/tmp/uploadFile.txt");
        FSDataInputStream inputStream = fs.open(path);
        FileOutputStream outputStream = new FileOutputStream("E:/project/github/hadoop/src/main/resources/data/uploadFile_output.txt");
        IOUtils.copyBytes(inputStream, outputStream, conf, true);
    }


    @Test
    public void blocks() throws Exception {


        Path path = new Path("/tmp/uploadFile.txt");
        FileStatus fss = fs.getFileStatus(path);

        BlockLocation[] fileBlockLocations = fs.getFileBlockLocations(fss, 0, fss.getLen());

        for (BlockLocation fileBlockLocation : fileBlockLocations) {
            System.out.println(fileBlockLocation);
        }
    }

    @Test
    public void readBlocks() throws Exception {


        Path path = new Path("/tmp/uploadFile.txt");
        FileStatus fss = fs.getFileStatus(path);

        BlockLocation[] fileBlockLocations = fs.getFileBlockLocations(fss, 0, fss.getLen());
        FSDataInputStream inputStream = fs.open(path);
        inputStream.seek(3);
        System.out.println((char) inputStream.readByte());
        System.out.println((char) inputStream.readByte());
        System.out.println((char) inputStream.readByte());
        System.out.println((char) inputStream.readByte());
        System.out.println((char) inputStream.readByte());
        System.out.println((char) inputStream.readByte());
    }

    @After
    public void after() throws IOException {
        fs.close();
        System.out.println("after");
    }
}
