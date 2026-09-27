package com.item;

public final class ItemCreationException extends Exception{

    public ItemCreationException(String msg){
        super(msg);
    }
    public ItemCreationException(String msg, Throwable cause){
        super(msg, cause);
    }

}
