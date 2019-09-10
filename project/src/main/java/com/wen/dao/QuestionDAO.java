package com.wen.dao;

import com.wen.model.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:HowieLee
 * @Date:1/7/2019
 * @Description:com.howie.wen.dao
 * @version:1.0
 */
@Mapper
@Component
@Repository
public interface QuestionDAO {
    String TABLE_NAME = " question ";
    String INSERT_FIELDS = " title, content, created_date, user_id, comment_count ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{title},#{content},#{createdDate},#{userId},#{commentCount})"})
    int addQuestion(Question question);

    List<Question> selectLatestQuestions(@Param("userId") int userId, @Param("offset") int offset,
                                         @Param("limit") int limit);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    Question getById(int id);


//    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
//    List<Question> getConversationList(@Param("userId") String userId,
//                                      @Param("offset") int offset, @Param("limit") int limit);


    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where title like CONCAT('%',#{q},'%')"})
    List<Question> selectsearchquestion(@Param("q") String q,
                                        @Param("offset") int offset, @Param("limit") int limit);


    @Update({"update ", TABLE_NAME, " set comment_count = #{commentCount} where id=#{id}"})
    int updateCommentCount(@Param("id") int id, @Param("commentCount") int commentCount);

}
