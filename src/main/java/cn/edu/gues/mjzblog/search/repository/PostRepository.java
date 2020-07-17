package cn.edu.gues.mjzblog.search.repository;

import cn.edu.gues.mjzblog.search.model.PostDocment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author TAHUN
 * @version 1.0
 * @date 2020/7/17 10:47
 */
@Repository
public interface PostRepository extends ElasticsearchRepository<PostDocment,Long> {

    //符合jpa命名规范的接口

}
