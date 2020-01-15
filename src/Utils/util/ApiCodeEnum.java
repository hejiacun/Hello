package Utils.util;

public class ApiCodeEnum {
    public interface BaseEnum {
        int getCode();
        String getDesc();
    }
    public enum CommonCode implements BaseEnum {
        /**
         * common code
         */
        DUPLICATE_NAME(1, "duplicate name"),
        SUCCESS(200, "success"),
        SERVER_ERROR(500, "server error"),
        ERROR(5, "error"),
        PARAM_ERROR(3, "param error"),
        SESSION_TIMEOUT(1001, "session timeout"),
        NEED_TOKEN(1002, "need token"),
        TRANSFER_TOKEN_TIMEOUT(1103, "transfer token timeout"),
        NO_AUTHORITY(401, "no authority"),
        SIGN_ILLEGAL(401, "sign illegal"),
        ;

        private int code;
        private String desc;
        CommonCode(int code, String desc) {
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
    
    public enum BusinessCode implements BaseEnum {
        ;

        private int code;
        private String desc;
        BusinessCode(int code, String desc) {
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

    public enum RoleCode implements BaseEnum {
        HAS_WORKER(10001, "have workers at this role"),
        ;

        private int code;
        private String desc;
        RoleCode(int code, String desc) {
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
    
    public enum TeamCode implements BaseEnum {
    	TEAM_NAME_EMPTY(20001,"team name empty"),
    	OUTBOUND_TEAM_BINDING(20002,"outbound team has been bound"),
    	;
    	private int code;
        private String desc;
        TeamCode(int code, String desc) {
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
    
    public enum WorkerCode implements BaseEnum {
    	WRONG_PASSWORD(2000, "wrong password"),
    	WORKER_NAME_REPEAT(2001,"worker name repeat"),
    	WORKER_NOT_EXISTS(2002,"worker not exists"),
    	ADD_WORKER_ERROR(2003,"add worker error"),
        WORKER_VERIFY_FAILURE(2004, "worker validate failure"),
        EDIT_WORKER_ERROR(2005,"edit worker error"),
        INBOUND_TEAM_UNIQUE(2006,"inbound team unique"),
        HANDOFF_TEAM_UNIQUE(2007,"handoff team unique"),
        OUTBOUND_TEAM_UNIQUE(2008,"outbound team unique"),
        OUTBOUND_TEAM_NO_TASK(2009,"outbound team no task"),
        INTERNAL_STAFF_LOGIN(2010,"internal staff should login by weixin"),
        NICK_NAME_REPEAT(2011,"nick name repeat"),
    	;
    	private int code;
    	private String desc;
    	WorkerCode(int code, String desc) {
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
    public enum ConditionCode implements BaseEnum {
    	CONDITION_CONFLICTING(3000, "condition conflicting"),
    	CONDITION_REPEATED(3001, "condition repeated"),
    	ORDER_SETTING_EMPTY(3002, "order setting empty"),
    	CONDITION_HAS_BEEN_BOUND(3003, "condition has been bound"),
    	;
    	private int code;
    	private String desc;
    	ConditionCode(int code, String desc) {
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
    public enum SopCode implements BaseEnum {
    	MESSAGE_TYPE_UNIQUE(4000, "message type unique"),
    	REPLY_OF_ORDER_SORT(4001, "reply of order must be behind order list"),
    	REPLY_OF_RETURN_REFUND_SORT(4002, "reply of return and refund must be behind return and refund application list"),
    	KNOWLEDGE_LIST_BINDING(4003, "know list bind by next point"),
    	REPLY_NAME_REPEAT(4004, "reply name repeat"),
        ORDER_SN_NOT_EXISTS(7008, "order sn not exists"),   //客服平台 order sn校验
        RETURNED_SN_NOT_EXISTS(7009, "returned order sn not exists"),   //客服平台 returned order sn校验
    	ORDER_LIST_BINDING(4005, "order list binding"),
    	RETURN_AND_REFUND_APPLICATION_LIST_BINDING(4006, "return and refund application list binding"),
        ORDER_LIST_MESSAGE_BINDING(4007, "order list message binding"),
        ROBOT_SOP_AND_KNOWLEDGE_LIST_BINDING(4008, "robot sop and knowledge list must be at the bottom"),
        NO_ORDER_NO_APPLICATION(4009, "no order or no application next point must be set"),
        NOT_CHOOSE(4010, "not choose next point must be set"),
        SOP_BINDING(4011, "sop binding"),
    	;
    	private int code;
    	private String desc;
    	SopCode(int code, String desc) {
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

    public enum CategoryCode implements BaseEnum {
        CATEGORY_REPEATE(7004, "category name repeated"), /**知识库类别名称重复*/
        CATEGORY_PARENT_NOTEXIST(7005, "category parentId not exist"), /**知识库父类别不存在*/
        CATEGORY_NOTEXIST(7006, "category not exist"), /**知识库类别不存在*/
        DEFAULT_CATEGORY_NOTEXIST(7007, "default category not exist"), /**默认的知识库类别不存在*/
        ;
        private int code;
        private String desc;
        CategoryCode(int code, String desc) {
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

    public enum IssueCode implements BaseEnum {
        /***/
        ISSUE_LANGUAGE_REPEATE(8004, "issue language name repeated"), /**语言重复*/
        ISSUE_CATEGORY_PARENT_NOTEXIST(8005, "category parentId not exist"), /**知识库父类别不存在*/
        ISSUE_CATEGORY_NOTEXIST(8006, "category parentId not exist"), /**知识库类别不存在*/
        ISSUE_ENGLISH_TITLE_REQUIRED(8007,"content and title is required when language is english"),
        ISSUE_ENGLISH_REQUIRED(8008,"english is required when add iuuse"),
        ISSUE_TITLE_REPEATE(8009,"issue title is repeated"), /** 知识库条目标题重复*/
        ISSUE_TITLE_NOTEXIST(8010,"issue title not exist"), /** 知识库条目标题不存在*/
        ISSUE_ENGLISH_LANGUAGE_CAN_NOT_DELETE(8011,"the English language is not allowed to delete"), /** 英语语言不允许删除*/
        SIMILIAR_TITLE_REPEATED(8012,"Attach failed. The title has been attached by other knowledge."),/** 机器人训练设置，similartTitle重复时提示*/
        KNOWABLE_IS_ATTACHED(8013,"Knowable cannot be disabled because it's attached by "), /** 知识库已经被绑定了*/
        QUESTION_CHECKED_TIMEOUT(8014,"question check timeout!"), /** 该问题领取已超时*/
        ;
        private int code;
        private String desc;
        IssueCode(int code, String desc) {
        	this.code = code;
        	this.desc = desc;
        }
        
        public int getCode() {
        	return code;
        }
        
        public String getDesc() {
        	return desc;
        }
        public static IssueCode fromCode(Integer code) {
        	for (IssueCode issueCode : IssueCode.values()) {
        		if (issueCode.getCode()==(code)) {
        			return issueCode;
        		}
        	}
        	return null;
        }
    }

    public enum UploadLogCode  implements BaseEnum {
        DUPLICATED_TITLE(101,"Duplicated Title."),
        CATEGORY_REQUIRED(102,"Category is required."),
        CATEGORY_NOTEXIST(103,"Category doesn't Exist."),
        EN_REQUIRED(104,"EN Title is required."),
        EN_NOTEXIST(105,"EN doesn't Exist."),
        TITLE_REQUIRED(106," Title is required."),
        CONTENT_REQUIRED(107," Content is required."),
        KEYWORDS_REQUIRED(108," Keywords is required."),
        BUSINESS_REQUIRED(109," Business is required."),
        BUSINESS_DATA_ERROR(110," Business data error."),
        FEEDBACK_REQUIRED(111," FeedBack is required."),
        FEEDBACK_DATA_ERROR(112," FeedBack data error."),
        OTHER_REASON(113,"Other reason"),
        TITLE_SUCCESS_ONLY(114,"Import title success but similar title duplicated"),
        SUCCESS(200,"save success"),
        ;
        private int code;
        private String desc;
        UploadLogCode(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }
        public static UploadLogCode fromCode(Integer code) {
            for (UploadLogCode uploadLogCode : UploadLogCode.values()) {
                if (uploadLogCode.getCode()==(code)) {
                    return uploadLogCode;
                }
            }
            return null;
        }
    }

    public enum PointCode implements BaseEnum {
        POINT_TITLE_CONFLICTING(3101, "point title duplicate"),
        NEGATIVE_CONDITION_IS_EXISTING(3102,"same parent point and same attach type , son point with negative condition is existing"),
        POINT_BINDING_BY_OUTBOUND_TASK(3103,"point binding by outbound task"),
        ;
        private int code;
        private String desc;
        PointCode(int code, String desc) {
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
}
