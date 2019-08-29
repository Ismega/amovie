package com.ecjtu.mega.amovie.repository;

import com.ecjtu.mega.amovie.entity.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RateRepository {

    @Insert("insert into score () values()")
    int insert(Score score);
}
