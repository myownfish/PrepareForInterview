package com.test.stream;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestMyException {

    public static void testExeption(String haha) throws IOException, MyException {
        if (haha == null)
            throw new IOException("haha is null");
        else {
            throw new MyException("Ops.. Exception Happend!!");

        }
    }

    public static void testException2(String a) throws IOException, MyException {
        TestMyException.testExeption(a);
    }

}
