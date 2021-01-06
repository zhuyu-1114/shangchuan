package com.yuntu.biz;

import com.yuntu.dao.CommentMapper;
import com.yuntu.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("commentBiz")
@Transactional
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
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Comment> getAll(int mid) {
        return commentMapper.getAll(mid);
    }

    @Override
    public int delComm(int cid) {
        return commentMapper.delComm(cid);
    }

    @Override
    public int addComm(Comment comment) {
        return commentMapper.addComm(comment);
    }
}
