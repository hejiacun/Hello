package Utils.util;

import java.util.HashMap;
import java.util.Map;

public class EnumUtil {
    public enum ValidateEnum {
        NO_SESSION_VALIDATE(0, "无需session验证"),
        API_INTERFACE_VALIDATE(1, "API接口验证"),   //服务接口调用
        ;

        private int code;
        private String desc;
        ValidateEnum(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
    
    public enum RelationEnum {
        BUSINESS_CHANNEL(1, "business channel relation"),
        ROLE_SYSTEM(2, "role system relation"),
        ROLE_AUTH_SYSTEM(3, "role-auth system relation"),
        ROLE_AUTH_TEAM(4, "role-auth team relation"),
        ROLE_AUTH_PARENT_RELATION(5, "role auth parent-child relation"),
        ;

        private int code;
        private String desc;
        RelationEnum(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
    
    public enum MessageType{
        DEFAULT(0, "default"),
    	RICH_TEXT(1,"Rich Text"),
    	KNOWLEDGE_ANSWER(2,"Knowledge Answer"),
    	KNOWLEDGE_LIST(3,"Knowledge List"),
    	ORDER_LIST(4,"Order List"),
    	REPLY_OF_ORDER(5,"Reply Of Order"),
    	RETURN_AND_REFUND_APPLICATION_LIST(6,"Return&Refund Application List"),
    	REPLY_OF_RETURN_AND_REFUND(7,"Reply of ReturnRefund"),
        SHIPPING_INFO(8, "Shipping Info"),
        COD_CONFIRMATION_LINK(9, "Cod Confirmation Link"),
        COD_OUTSTANDING_DELIVERY_LINK(10, "Cod Outstanding Delivery Link"),
        ROBOT_SOP_AND_KNOWLEDGE_LIST(11, "Robot SOP&Knowledge List"),
        AGENT_NOTE(12, "Agent Note"),
    	;
    	private int code;
        private String desc;
        MessageType(int code, String desc) {
        	this.code = code;
        	this.desc = desc;
		}
        public int getCode() {
        	return code;
        }
        
        public String getDesc() {
        	return desc;
        }
        public static MessageType getMessageType(int code) {
            for(MessageType e : MessageType.values()) {
                if(e.getCode() == code) {
                    return e;
                }
            }
            return DEFAULT;
        }
    }
    
    public enum LanguageEnum {
        LANGUAGE_EN(0, "EN"),       //英语
        LANGUAGE_AR(1, "AR"),       //阿语
        LANGUAGE_ES(2, "ES"),       //西班牙语
        LANGUAGE_FR(3, "FR"),       //法语
        LANGUAGE_IT(4, "IT"),       //意大利
        LANGUAGE_JA(5, "JA"),       //日语
        LANGUAGE_PL(6, "PL"),       //波兰
        LANGUAGE_TW(8, "zh-TW"),    //繁体中文
        LANGUAGE_TR(9, "TR"),       //土耳其语
        LANGUAGE_CN(10, "CN"),      //简体中文
        LANGUAGE_FA(11, "FA"),      //波斯语
        LANGUAGE_ID(12, "ID"),      //印尼语
        LANGUAGE_UR(13, "UR");      //乌尔都语（巴基斯坦的官方语言）
        ;
        
        private int code;
        private String language;
        LanguageEnum(int code, String language) {
            this.code = code;
            this.language = language;
        }

        public int getCode() {
            return code;
        }

        public String getLanguage() {
            return language;
        }
        public static String getLanguage(int code) {
            for(LanguageEnum e : LanguageEnum.values()) {
                if(e.getCode() == code) {
                    return e.getLanguage();
                }
            }
            return "EN";    //找不到 默认EN
        }
        public static Integer getCode(String language) {
            for(LanguageEnum e : LanguageEnum.values()) {
                if(language.equals(e.getLanguage())) {
                    return e.getCode();
                }
            }
            return 0;
        }
    }

    /**
     * crm_consultation_record ---> consultation_type
     */
    public enum ConsultationTypeEnum {
        CHAT(1, "jolly chat"),
        ROBOT(2, "jolly robot"),
        INBOUND(3, "inbound"),
        OUTBOUND(4, "outbound"),
        ABANDON(5, "jolly chat abandon"),   //在线聊天 排队放弃
        ;
        private int code;
        private String desc;
        ConsultationTypeEnum(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }

    /**
     * crm_consultation_sheet_relation ---> relation_type
     */
    public enum ConsultationRelationEnum {
        ORDER_NO(1, "order no"),
        TRACKING_NO(2, "tracking no"),
        SHEET_NO(3, "sheet no"),
        CALL_ID(4, "call id"),
        TICKET_ID(5, "ticket id"),
        CHAT_ID(6, "chat id"),
        ;
        private int code;
        private String desc;
        ConsultationRelationEnum(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
    public enum CustomerTagEnum {
        /**用户标签*/
        HIGH_CONSULTATION_RATE_NEW("A220U014_0_001", "High Consultation Rate"),             //高重复咨询用户 新标签
        HIGH_RETURN_RATE_NEW("A220U015_0_001", "High Return&Refund Rate"),                  //高退货用户 新标签
        HIGH_COMPLAINT_RATE_NEW("A220U016_0_001", "High Complaint Rate"),                   //高投诉用户 新标签
        HIGH_CONSULTATION_RATE("A120U014_0_001", "High Consultation Rate"),             //高重复咨询用户
        HIGH_RETURN_RATE("A120U015_0_001", "High Return&Refund Rate"),                  //高退货用户
        HIGH_COMPLAINT_RATE("A120U016_0_001", "High Complaint Rate"),                   //高投诉用户
        IMPORTANT_VALUE_CUSTOMER("A111U008_0_001", "Important Value Customer"),         //重要价值用户
        IMPORTANT_DEVELOP_CUSTOMER("A111U008_0_002", "Important Develop Customer"),     //重要发展用户
        IMPORTANT_KEEP_CUSTOMER("A111U008_0_003", "Important Keep Customer"),           //重要保持用户
        IMPORTANT_RETAIN_CUSTOMER("A111U008_0_004", "Important Retain Customer"),       //重要挽留用户
        SEG1("330771", "VSEG1"),                                        //SEG1/4/5/6 预流失用户挽回
        SEG4("330773", "VSEG4"),
        SEG5("330775", "VSEG5"),
        SEG6("330777", "VSEG6"),
        SEG2_SHOPPED("330781", "VSEG2&Shopped In 3 Months"),            //SEG2/3 预流失用户挽回
        SEG2_NO_SHOPPING("330779", "VSEG2&No Shopping In 3 Months"),
        SEG3_SHOPPED("330783", "VSEG3&Shopped In 3 Months"),
        SEG3_NO_SHOPPING("330785", "VSEG3&No Shopping In 3 Months"),
        LOST_SHOPPED("330723", "Have Shopping History"),                //已流失用户挽回
        LOST_NO_SHOPPING("330787", "No Shopping History"),
        ;

        private String tagId;
        private String tagName;
        private static Map<String, CustomerTagEnum> enumMap = new HashMap<>();
        //key：seg序号，value：tagId
        private static Map<Integer, String> segMap = new HashMap<>();
        static {
            for (CustomerTagEnum e : CustomerTagEnum.values()) {
                enumMap.put(e.getTagId(), e);
                if(e.getTagName().indexOf("VSEG")>=0){
                    Integer segNo = Integer.valueOf(e.getTagName().substring(e.getTagName().indexOf("VSEG")+4,e.getTagName().indexOf("VSEG")+5));
                    //segMap.put(segNo,e.getTagId());
                    segMap.merge(segNo,e.getTagId(),(x,y)->x+","+y);
                }
            }
        }
        CustomerTagEnum(String tagId, String tagName) {
            this.tagId = tagId;
            this.tagName = tagName;
        }
        public String getTagId() {
            return tagId;
        }

        public String getTagName() {
            return tagName;
        }

        public static Map<Integer, String> getSegMap() {
            return segMap;
        }

        public static CustomerTagEnum getEnumByCode(String tagId) {
            return enumMap.get(tagId);
        }

        public static String[]  getTagArr() {
            int length = CustomerTagEnum.values().length;
            String[] tagArr = new String[length];
            for(int i = 0; i< CustomerTagEnum.values().length; i++) {
                tagArr[i] = CustomerTagEnum.values()[i].getTagId();
            }
            return tagArr;
        }

        public static CustomerTagEnum getEnumByName(String name) {
            for(CustomerTagEnum e : CustomerTagEnum.values()) {
                if(name.equalsIgnoreCase(e.getTagName())) {
                    return e;
                }
            }
            return null;
        }

    }
    
    public enum ConsultationStatus {
    	AGENT_SERVICE(1,"Agent Service"),
    	ROBOT_SERVICE(2,"Robot Service"),
    	ABANDONED(3,"Abandoned"),
    	DISCONNECTED(4,"Disconnected"),
    	IVR(5,"IVR"),
    	EMPTY(6,"Empty"),
        CHAT_AGENT_SERVICE_ABANDONED_WITHIN_20s(7, "Chat Agent Service-Abandoned in Queue(Within 20s)"),
        CHAT_AGENT_SERVICE_ABANDONED_AFTER_20s(8, "Chat Agent Service-Abandoned in Queue(After 20s)"),
        CHAT_AGENT_SERVICE_AGENT_NO_RESPOND_WITHIN_20s(9, "Chat Agent Service-Agent No Respond(Within 20s)"),
        CHAT_AGENT_SERVICE_AGENT_NO_RESPOND_AFTER_20s(10, "Chat Agent Service-Agent No Respond(After 20s)"),
        CHAT_AGENT_SERVICE_CUSTOMER_NO_RESPOND(11, "Chat Agent Service-Customer No Respond"),
        CHAT_AGENT_SERVICE_AGENT_AND_CUSTOMER_NO_RESPOND_WITHIN_20S(12, "Chat Agent Service-Agent&Customer No Respond(Within 20s)"),
        CHAT_AGENT_SERVICE_AGENT_AND_CUSTOMER_NO_RESPOND_AFTER_20S(13, "Chat Agent Service-Agent&Customer No Respond(After 20s)"),
        CHAT_AGENT_SERVICE_AGENT_AND_CUSTOMER_RESPOND(14, "Chat Agent Service-Agent&Customer Respond"),
        CHAT_AGENT_SERVICE_ABANDONED_IN_WHATSAPP(15, "Chat Agent Service-Abandoned in WhatsApp"),
        CHAT_ROBOT_SERVICE_ABANDONED_BEFORE_CHATTING(16, "Chat Robot Service-Abandoned Before Chatting"),
        CHAT_ROBOT_SERVICE_VALID_CHAT(17, "Chat Robot Service-Valid Chat"),
        CHAT_ROBOT_SERVICE_ABANDONED_IN_WHATSAPP(18, "Chat Robot Service-Abandoned in WhatsApp"),
    	;
    	private int code;
    	private String status;
		private ConsultationStatus(int code, String status) {
			this.code = code;
			this.status = status;
		}
		public int getCode() {
			return code;
		}
		public String getStatus() {
			return status;
		}
        public static String getStatusByCode(int code) {
            for(ConsultationStatus e : ConsultationStatus.values()) {
                if(e.getCode() == code) {
                    return e.getStatus();
                }
            }
            return "";    //找不到 默认""
        }
    }

    /**
     * 访客来源
     */
    public enum SourceTypeEnum {
        ANDROID(1, "LiveChat-Android"),
        IPHONE(2, "LiveChat-Iphone"),
        IPAD(3, "LiveChat-Ipad"),
        WEB(10, "LiveChat-Web"),
        WAP(11, "LiveChat-Wap"),
        INBOUND(12, "Inbound"),
        SYSTEM_OUTBOUND(13, "System Outbound"),
        MANUAL_OUTBOUND(14, "Manual Outbound"),
        SYSTEM(15, "System"),
        EMAIL(16, "E-mail"),
        CS_CREATED(17, "CS Created"),
        GOVERNMENT(18, "Government"),
        WHATSAPP(19, "WhatsApp"),
        FACEBOOK(20, "Facebook"),
        TWITTER(21, "Twitter"),
        INSTAGRAM(22, "Instagram"),
        YOUTUBE(23, "YouTube"),
        REVIEW_WEBSITE(24, "Review Website"),
        ;
        private int code;
        private String source;

        SourceTypeEnum(int code, String source) {
            this.code = code;
            this.source = source;
        }

        public int getCode() {
            return code;
        }

        public String getSource() {
            return source;
        }
        public static String getSourceByCode(int code) {
            for(SourceTypeEnum e : SourceTypeEnum.values()) {
                if(e.getCode() == code) {
                    return e.getSource();
                }
            }
            return "";    //找不到 默认""
        }
    }
}
