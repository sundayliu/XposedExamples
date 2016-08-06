package com.sundayliu.demo.login;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.sundayliu.demo.login.LoginTest \
 * com.sundayliu.demo.login.tests/android.test.InstrumentationTestRunner
 */
public class LoginTest extends ActivityInstrumentationTestCase2<Login> {

    public LoginTest() {
        super("com.sundayliu.demo.login", Login.class);
    }

}
