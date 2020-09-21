package com.brainroot.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1" ;
    }

    @Override
    public String getBucketName() {
        return "default";
    }

    @Override
    public String getUserName(){
        return "Administrator";
    }

    @Override
    public String getPassword() {
        return "password";
    }
}
