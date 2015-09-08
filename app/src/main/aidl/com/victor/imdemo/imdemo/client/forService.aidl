// forService.aidl
package com.victor.imdemo.imdemo.client;
import com.victor.imdemo.imdemo.client.forActivity;

// Declare any non-default types here with import statements

interface forService {

    void registerTestCall(forActivity activity);
    void invokCallback();

    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
