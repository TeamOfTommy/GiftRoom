package com.giftroom.Jsms.Impl;

import cn.jsms.api.SendSMSResult;
import cn.jsms.api.ValidSMSResult;
import cn.jsms.api.common.SMSClient;
import cn.jsms.api.common.model.SMSPayload;
import com.giftroom.Jsms.IJsmsService;
import com.giftroom.Jsms.JsmsKey;
import com.giftroom.utils.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by tommy on 2017/10/22.
 */
@Service
public class JsmsServiceImpl implements IJsmsService {

    private final static Logger logger = LoggerFactory.getLogger(JsmsServiceImpl.class);

    public String sendSMSCode(String telnumber) {
        SMSClient client = new SMSClient(JsmsKey.masterSecret,JsmsKey.appKey);
        String msgId = "";
        try{
            SMSPayload payload = SMSPayload.newBuilder()
                    .setMobileNumber(telnumber)
                    .setTempId(1)
                    .build();
            SendSMSResult res =  client.sendSMSCode(payload);
            logger.info(res.toString());
            return res.getMessageId();
        }catch (Exception e){
            logger.error("jsms send message error:\n", e);
        }
        return msgId;
    }

    public Boolean sendValidSMSCode(String msg_id, String validCode){
        SMSClient client = new SMSClient(JsmsKey.masterSecret,JsmsKey.appKey);
        Boolean valid = Boolean.FALSE;
        try{
            ValidSMSResult res
                    = client.sendValidSMSCode(msg_id ,validCode);
            valid = res.getIsValid();
        }catch (Exception e){
            logger.error("jsms valid error:\n",e);
        }
        return valid;
    }
}
