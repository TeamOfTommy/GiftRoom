package com.giftroom.Jsms;

/**
 * Created by tommy on 2017/10/22.
 */
public interface IJsmsService {

    String sendSMSCode(String telnumber);

    Boolean SendValidSMSCode(String msg_id, String validCode);

}
