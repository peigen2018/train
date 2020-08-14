package com.pg.bigdata.hadoop.topn;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

//序列化/反序列化   比较器
public class TopNKey implements WritableComparable<TopNKey> {
    private int year;
    private int month;
    private int day;
    private double temperature;
    private String location;


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int compareTo(TopNKey that) {
        //我们为了让这个案例体现api开发，所以下边的逻辑是一种通用的逻辑：按照时间正序，
        //但是我们目前业务需要的是  年，月，温度，且温度倒序，所以一会还得开发一个sortComparator。。。。

        //the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y
        int c1 = Integer.compare(this.year, that.getYear());

        if (c1 == 0) {
            int c2 = Integer.compare(this.month, that.getMonth());
            if (c2 == 0) {
                return Integer.compare(this.day, that.getDay());
            }
            return c2;
        }

        return c1;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(this.year);
        out.writeInt(this.month);
        out.writeInt(this.day);
        out.writeDouble(this.temperature);
        out.writeUTF(this.location);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.year = in.readInt();
        this.month = in.readInt();
        this.day = in.readInt();
        this.temperature = in.readDouble();
        this.location = in.readUTF();
    }
}
