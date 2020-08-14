package com.pg.bigdata.hadoop.topn;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class TopNMapper extends Mapper<LongWritable, Text, TopNKey, DoubleWritable> {
    TopNKey mkey = new TopNKey();
    DoubleWritable mval = new DoubleWritable();

    public HashMap<String, String> dict = new HashMap<String, String>();

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {

        URI[] cacheFiles = context.getCacheFiles();
        String path = cacheFiles[0].getPath();
        BufferedReader reader = new BufferedReader((new FileReader(new File(path))));

        String line = reader.readLine();

        while (line != null) {
            String[] locations = line.split("\t");
            dict.put(locations[0], locations[1]);
            line = reader.readLine();
        }

    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // value:  2019-6-1 22:22:22	1	31
        String[] strings = value.toString().split("\t");


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(strings[0]);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);


            mkey.setYear(calendar.get(Calendar.YEAR));
            mkey.setMonth(calendar.get(Calendar.MONTH) + 1);
            mkey.setDay(calendar.get(Calendar.DAY_OF_MONTH));

            mkey.setLocation(dict.get(strings[1]));

            Double temperature = Double.valueOf(strings[2]);
            mkey.setTemperature(temperature);


            mval.set(temperature);
            context.write(mkey, mval);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
