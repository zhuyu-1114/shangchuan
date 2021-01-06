package com.yuntu.biz;

import com.yuntu.dao.CommentMapper;
import com.yuntu.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommentBiz")
public class CommentBizImpl implements CommentBiz {

    @Autowired
    private CommentMapper commentMapper;

    public CommentMapper getCommentMapper() {
        return commentMapper;
    }

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<Comment> selOne(int mid) {
        return commentMapper.selOne(mid);
    }

    @Override
    public int delComm(int cid) {
        return commentMapper.delComm(cid);
    }

    @Override
    public int updComm(Comment comment) {
        return commentMapper.updComm(comment);
    }

    @Override
    public int addComm(Comment comment) {
        return commentMapper.addComm(comment);
    }

    @Override
    public Comment selOneC(int cid) {
        return commentMapper.selOneC(cid);
    }
}
