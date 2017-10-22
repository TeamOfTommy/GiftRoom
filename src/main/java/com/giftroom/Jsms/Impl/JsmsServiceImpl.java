package com.giftroom.Jsms.Impl;

import cn.jsms.api.SendSMSResult;
import cn.jsms.api.common.SMSClient;
import cn.jsms.api.common.model.SMSPayload;
import com.giftroom.Jsms.IJsmsService;
import com.giftroom.Jsms.JsmsKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by tommy on 2017/10/22.
 */
@Service
public class JsmsServiceImpl implements IJsmsService {

    private final static Logger logger = LoggerFactory.getLogger(JsmsServiceImpl.class);

    public void sendValidSMSCode(String telnumber) {
        SMSClient client = new SMSClient(JsmsKey.masterSecret,JsmsKey.appKey);
        try{
            SMSPayload payload = SMSPayload.newBuilder()
                    .setMobileNumber(telnumber)
                    .setTempId(1)
                    .build();
            SendSMSResult res =  client.sendSMSCode(payload);
            //ValidSMSResult res = client.sendValidSMSCode("01658697-45d9-4644-996d-69a1b14e2bb8", "556618");
            logger.info(res.toString());
        }catch (Exception e){
            logger.error("jsms send message error:\n", e);
        }
    }
}
