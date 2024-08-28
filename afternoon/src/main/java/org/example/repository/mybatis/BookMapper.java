package org.example.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.domain.BookMyBatis;

import java.util.List;

@Mapper
public interface BookMapper {
    public List<BookMyBatis> findAll();
    public BookMyBatis findById(@Param("id") Long id);
    public int save(BookMyBatis newBook);
    public int delete(@Param("id") Long id);
}