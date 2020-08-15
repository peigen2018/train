package com.dbapp.analyse.stream;

import com.dbapp.analyse.stream.job.DBAuditJob;

public class Application {
    public static void main(String[] args) throws Exception {
        DBAuditJob job = new DBAuditJob();
        job.execute("DB Audit Job");
    }
}
