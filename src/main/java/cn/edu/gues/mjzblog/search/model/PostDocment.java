package cn.edu.gues.mjzblog.search.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author TAHUN
 * @version 1.0
 * @date 2020/7/17 10:41
 */
@Data
@Document(indexName = "post",type = "post",createIndex = true)
public class PostDocment implements Serializable {

    @Id
    private Long id;

    // ik分词器
    @Field(type = FieldType.Text, searchAnalyzer="ik_smart", analyzer = "ik_max_word")
    private String title;

    @Field(type = FieldType.Long)
    private Long authorId;

    @Field(type = FieldType.Keyword)
    private String authorName;
    private String authorAvatar;

    private Long categoryId;
    @Field(type = FieldType.Keyword)
    private String categoryName;

    private Integer level;
    private Boolean recomment;

    private Integer commentCount;
    private Integer viewCount;

    @Field(type = FieldType.Date)
    private Date created;

}
