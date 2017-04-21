package com.example.util.jpa.page;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by SCC on 2017/1/16.
 */
public class PageBuilder {

    /**
     * 以常量的形式存储，在实际的运用中应该从properties文件中取得，思路都一样
     * */
    public static final int size = 10;

    public static Pageable generate(int page, int size, Sort sort) {
        if(sort==null) return new PageRequest(page, size);
        return new PageRequest(page, size, sort);
    }

    public static Pageable generate(int page) {
        return generate(page,size,null);
    }

    public static Pageable generate(int page, Sort sort) {
        return generate(page,size,sort);
    }
}