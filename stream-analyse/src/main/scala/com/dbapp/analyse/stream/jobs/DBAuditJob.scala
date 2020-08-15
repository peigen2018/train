package com.dbapp.analyse.stream.jobs

import java.util.Properties

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, _}
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer

case class DBAuditLog (logType: String,
                       startTime: String,
                       sqlLen: String,
                       clientUserName: String,
                       srcHostName: String,
                       dvcAction: String,
                       destMacAddress: String,
                       opType: String,
                       databaseName: String,
                       srcMacAddress: String,
                       destAddress: String,
                       logSessionId: String,
                       alarmFlag: String,
                       responseCode: String,
                       destPort: String,
                       srcUserName: String,
                       relateIp: String,
                       payload: String,
                       severity: String,
                       srcAddress: String,
                       clientPrg: String,
                       dataSet: String,
                       relateUser: String,
                       tenant: String,
                       sqlId: String,
                       costTime: String,
                       databaseType: String,
                       ruleName: String,
                       errorMessage: String,
                       accessId: String,
                       relateUserInfo: String,
                       effectRow: String,
                       srcPort: String,
                       dataSetSize: String,
                       relateUrl: String,
                       deviceAddress: String,
                       deviceSendProductName: String,
                       deviceSendProductVersion: String,
                       collectorReceiptTime: String,
                       deviceReceiptTime: String,
                       endTime: String,
                       catTechnique: String,
                       catBehavior: String,
                       catOutcome: String,
                       direction: String,
                       eventId: String)

class DBAuditJob {

  def execute(): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val properties = new Properties()
    properties.setProperty("bootstrap.servers", "192.168.30.79:19092")
    properties.setProperty("zookeeper.connect", "192.168.30.79:12181")

    val mapper: ObjectMapper = new ObjectMapper()


    val dbStream = env.addSource(new FlinkKafkaConsumer[String]("com.dbapp.dbaudit",
      new SimpleStringSchema(), properties))

    //   dbStream.print()
    dbStream.map(mapper.readValue(_ , classOf[DBAuditLog])).print()

    env.execute("Socket Window WordCount")
  }
}
