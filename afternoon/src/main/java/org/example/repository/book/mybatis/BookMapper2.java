package org.example.repository.book.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.domain.BookMyBatis;

import java.util.List;

@Mapper
public interface BookMapper2 {
    public List<BookMyBatis> findAll();
    public BookMyBatis findById(@Param("id")Long id);
    public int save(BookMyBatis newBookMyBatis);
    public int delete(Long id);
}
