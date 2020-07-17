package cn.edu.gues.mjzblog.service;

import cn.edu.gues.mjzblog.entity.vo.PostVo;
import cn.edu.gues.mjzblog.search.mq.PostMqIndexMessage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface SearchService {

    IPage search(Page page, String keyword);

    int initEsData(List<PostVo> records);

    void createOrUpdateIndex(PostMqIndexMessage message);

    void removeIndex(PostMqIndexMessage message);
}
