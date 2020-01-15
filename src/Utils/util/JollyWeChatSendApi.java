package Utils.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class JollyWeChatSendApi {
    private static final Logger logger = LoggerFactory.getLogger(JollyWeChatSendApi.class);

    private static final String HOST = "https://qyapi.weixin.qq.com",
            CORP_ID = "ww8385ff43f8e787f7",
            CORP_SECRET = "WYsOoloiFhAwS8p9X_wE1uDW_Z6OuaadP70d1Ke2GUM",
            GET_TOKEN_PATH = "/cgi-bin/gettoken",
            SEND_MSG_PATH = "/cgi-bin/message/send";
    private static final int AGENT_ID = 1000005;

    public String getToken() {
        try {
            String url = HOST + GET_TOKEN_PATH + String.format("?corpid=%s&corpsecret=%s", CORP_ID, CORP_SECRET);
            String result = HttpClient.doGet(url);
            Map<String, Object> map = ObjectUtils.json2Map(result);
            if(map.containsKey("access_token")) {
                return map.get("access_token").toString();
            }
            return null;
        }catch (Exception e){
            throw new RuntimeException("get wechat token failed.");
        }
    }

    private final Map<String,Object> tokenCache = new ConcurrentHashMap<>();
    private static final long TOKEN_EXPIRES_IN = 7200 * 1000;
    private String getCachedToken(boolean refresh) {
        if(refresh || !tokenCache.containsKey("wechatToken")
                || System.currentTimeMillis() - (long)tokenCache.get("timestamp") > TOKEN_EXPIRES_IN){
            tokenCache.put("wechatToken", getToken());
            tokenCache.put("timestamp", System.currentTimeMillis());
        }
        return (String)tokenCache.get("wechatToken");
    }
    public String getCachedToken(){
        return getCachedToken(false);
    }

    public Map<String, Object> buildMsgBody(final String title, final String content, final List<String> receivers) {
        //消息体参考https://work.weixin.qq.com/api/doc#90000/90135/90236
        Map<String, Object> params = new HashMap<>();
        params.put("touser", StringUtils.join(receivers,"|"));
        params.put("msgtype","text");
        params.put("agentid",AGENT_ID);
        Map<String, Object> msg = new HashMap<>(1);
        msg.put("content", title+"\n"+content);
        params.put("text", msg);
        return params;
    }

    public void sendMessage(final String title, final String content, final List<String> receivers){
        Map<String, Object> msgBody = buildMsgBody(title,content,receivers);
        sendMessage(msgBody);
    }

    public void sendMessage(Map<String, Object> msg) {
        String url = HOST + SEND_MSG_PATH + "?access_token=" + getCachedToken();
        String resp = doSend(url, msg);
        if(StringUtils.isNotBlank(resp) && resp.contains("invalid access_token")){
            url = HOST + SEND_MSG_PATH + "?access_token=" + getCachedToken(true);;
            doSend(url, msg);
        }
    }

    private String doSend(String url,Map<String, Object> msg) {
        try {
            String result = HttpClient.doPost(url, msg);
            LogUtils.info("send to wechat, result:{}", result);
            return result;
        }catch(Exception e){
            logger.error("msg send failed.",e);
            return "";
        }
    }
}
