package com.yuntu.biz;

import com.yuntu.pojo.Comment;

import java.util.List;

public interface CommentBiz {

    List<Comment> selOne(int mid);

    int delComm(int cid);

    int updComm(Comment comment);

    int addComm(Comment comment);

    Comment selOneC(int cid);
}
