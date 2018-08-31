package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class EmptyStringTest extends AndroidTestCase {


    @SuppressWarnings("unchecked")
    public void test() throws Throwable {

        final CountDownLatch signal = new CountDownLatch(1);

        String result = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(new EndpointsAsyncTask.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                signal.countDown();
            }
        });
        endpointsAsyncTask.execute(getContext());
        try {
            result = endpointsAsyncTask.get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            fail("Fail");
        }
        assertNotNull(result);
        signal.await();
    }
}