package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

public class EmptyStringTest extends AndroidTestCase {

    private static final String LOG_TAG = "EmptyStringTest";

    @SuppressWarnings("unchecked")
    public void test() {
        String result = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute(getContext());
        try {
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}