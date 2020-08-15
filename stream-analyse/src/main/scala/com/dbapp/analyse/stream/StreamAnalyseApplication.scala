package com.dbapp.analyse.stream

import com.dbapp.analyse.stream.jobs.DBAuditJob

object StreamAnalyseApplication {

  def main(args: Array[String]): Unit = {
    val job = new DBAuditJob();
    job.execute()
  }
}
