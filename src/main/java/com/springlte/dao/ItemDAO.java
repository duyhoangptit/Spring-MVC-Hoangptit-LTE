package com.springlte.dao;

import com.springlte.entities.Blog;
import com.springlte.entities.Item;

import java.awt.print.Pageable;
import java.util.List;

/**
 * author Hoangptit
 * Date 8/7/2016
 */
public interface ItemDAO {

    Item saveItem(Item item);

    List<Item> findByBlog(Blog blog, Pageable pageable);

    Item findByBlogAndLink(Blog blog, String link);
}
