package com.test.stream;

public interface MySecondCloseable extends MyCloseable {
    @Override
    void close() throws Error;

}
