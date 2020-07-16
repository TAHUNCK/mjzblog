package cn.edu.gues.mjzblog.template;

import cn.edu.gues.mjzblog.common.templates.DirectiveHandler;
import cn.edu.gues.mjzblog.common.templates.TemplateDirective;
import cn.edu.gues.mjzblog.common.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 本周热议
 */
@Component
public class HotsTemplate extends TemplateDirective {

    @Autowired
    RedisUtil redisUtil;

    @Override
    public String getName() {
        return "hots";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {
        String weekRankKey = "week:rank";

        Set<ZSetOperations.TypedTuple> typedTuples = redisUtil.getZSetRank(weekRankKey, 0, 6);

        List<Map> hotPosts = new ArrayList<>();

        for (ZSetOperations.TypedTuple typedTuple : typedTuples) {
            Map<String, Object> map = new HashMap<>();

            // post的id
            Object value = typedTuple.getValue();
            String postKey = "rank:post:" + value;

            map.put("id", value);
            map.put("title", redisUtil.hget(postKey, "post:title"));
            map.put("commentCount", typedTuple.getScore());

            hotPosts.add(map);
        }

        handler.put(RESULTS, hotPosts).render();

    }
}
