package Utils.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Constants {
	public static final String SESSION_KEY = "WORKER";
	public static final int JOLLYCHIC_COMPANY_ID = 100000;
	public static final String BEFORE = " (<b style='color: orange'>Before</b>) ";
	public static final String AFTER = " (<b style='color: #19be6b'>After</b>) ";

    private static Constants instance = new Constants();
//	public static Constants getSingleston() {
//		return instance;
//	}
    public static Constants getInstance() {
    	instance = SpringUtil.getBean(Constants.class);
    	return instance;
    }
}
