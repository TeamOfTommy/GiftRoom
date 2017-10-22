package com.giftroom.Exception;

/**
 * Created by tommy on 2017/10/22.
 */
public class GiftRoomException extends Exception {

    private Code code;

    public GiftRoomException(String message, Throwable e, Code code) {
        super(message, e);
        this.code = code;
    }

    public GiftRoomException(String message, Code code) {
        this(message, null, code);
        this.code = code;
    }

    public GiftRoomException(String message) {
        this(message, null, null);
    }

    public Code getCode() {
        return code;
    }
}
