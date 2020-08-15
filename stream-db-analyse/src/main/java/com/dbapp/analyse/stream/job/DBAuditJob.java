package com.dbapp.analyse.stream.job;

import com.dbapp.analyse.stream.dto.AdultLogBody;
import com.dbapp.analyse.stream.utils.JacksonJsonUtils;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import java.util.Properties;

public class DBAuditJob {
    public void execute(String jobName) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.30.79:19092");
        properties.setProperty("zookeeper.connect", "192.168.30.79:12181");
        // TODO 记录offset以便下次继续消费

        // TODO check point

        // TODO save point


        DataStream<String> stream = env
                .addSource(new FlinkKafkaConsumer<>("com.dbapp.dbaudit", new SimpleStringSchema(), properties));


       stream.map(json -> JacksonJsonUtils.fromJson(json, AdultLogBody.class)).filter(adultlog->{

           // TODO 过滤掉有缺损的数据
           // TODO 验证server 端口等信息

           return true;
       }).map(e->{
           System.out.println("----------------------------------");
           // TODO 解析结果集
           System.out.println(e.getDataSet());
           return e;
       });


        // get dataSet


        FlinkKafkaProducer<String> myProducer = new FlinkKafkaProducer<>("com.dbapp.dbaudit.out",
                new SimpleStringSchema(), properties);

        // TODO 目前这个是到kafka
        //  TODO 可以手动定义sink保存到图库
        stream.addSink(myProducer);
        env.execute(jobName);
    }
}
