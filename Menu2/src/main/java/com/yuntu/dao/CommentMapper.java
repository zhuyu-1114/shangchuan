package com.yuntu.dao;

import com.yuntu.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    public List<Comment> getAll(@Param("mid") int mid);
    public int delComm(@Param("cid") int cid);
    public int addComm(Comment comment);

    public int del(@Param("mid") int mid);
}
