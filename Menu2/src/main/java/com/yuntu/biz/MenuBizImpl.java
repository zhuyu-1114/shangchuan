package com.yuntu.biz;

import com.yuntu.dao.CommentMapper;
import com.yuntu.dao.MenuMapper;
import com.yuntu.pojo.Menu;
import com.yuntu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("menuBiz")
@Transactional
public class MenuBizImpl implements MenuBiz{
    @Autowired
    private MenuMapper menuMapper;
    public MenuMapper getMenuMapper() {
        return menuMapper;
    }

    public void setMenuMapper(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

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
    public void getPage(PageUtil<Menu> pageUtil) {
        int count = menuMapper.getCount();
        if(count>0){
            pageUtil.setCounts(count);
            if(pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            int index = (pageUtil.getPageindex()-1)*pageUtil.getPagesize();
            int size = pageUtil.getPagesize();
            pageUtil.setLists(menuMapper.getPage(index,size));
        }else{
            pageUtil.setLists(new ArrayList<Menu>());
        }
    }

    @Override
    public int addMenu(Menu menu) {
        return menuMapper.addMenu(menu);
    }

    @Override
    public int delMenu(int mid) {
        commentMapper.del(mid);
        return menuMapper.delMenu(mid);
    }

    @Override
    public Menu selMenu(int mid) {
        return menuMapper.selMenu(mid);
    }

    @Override
    public int updMenu(Menu menu) {
        return menuMapper.updMenu(menu);
    }
}
