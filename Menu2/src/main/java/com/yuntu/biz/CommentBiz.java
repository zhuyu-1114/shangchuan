package com.yuntu.biz;

import com.yuntu.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentBiz {
    public List<Comment> getAll(int mid);
    public int delComm(int cid);
    public int addComm(Comment comment);
}
