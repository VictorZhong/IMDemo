// IMyAidlInterface.aidl
package com.victor.imdemo.imdemo.aidl;

// Declare any non-default types here with import statements

interface IMyAidlInterface {

    int getPid();

    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}