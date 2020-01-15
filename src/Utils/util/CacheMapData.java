package Utils.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: hejiacun
 * @create: 2019-02-27 18:03
 **/
@Component
public class CacheMapData implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(CacheMapData.class);

    /**
     * 节点ID与sop的映射
     */
    private final static Map<Integer, String> workplaceNameMap = new HashMap<>();

    private final static Map<Integer, Integer> userWorkPaleceMap = new HashMap<>();

    private final static Map<Integer, String> agentNameMap = new HashMap<>();
    private final static Map<Integer, String> teamNameMap = new HashMap<>();
    private final static Map<Integer, String> outboundTaskNameMap = new HashMap<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
            service.scheduleAtFixedRate(runnable, 0, 60, TimeUnit.MINUTES);
        } catch (Exception e) {
            logger.error(String.format("EXCEPTION,MyApplicationRunner run:", e));
        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {


        }
    };


    public static Map<Integer, Integer> getUserWorkPaleceMap() {
        return userWorkPaleceMap;
    }
}
