package com.yuntu.dao;

import com.yuntu.pojo.Comment;

import java.util.List;

public interface CommentMapper {

    List<Comment> selOne(int sid);

    int delComm(int cid);

    int updComm(Comment comment);

    int addComm(Comment comment);

    Comment selOneC(int cid);
}
