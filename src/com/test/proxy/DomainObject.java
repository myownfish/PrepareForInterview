package com.test.proxy;

public interface DomainObject {

    public default void setUsername(String name) {
        
    }
    
    public default String getUsername() {
        return null;
    }
}
