package com.bnuz.commons.baseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by QuanQqqqq on 2018/4/2.
 */
public interface BaseService<T,ID extends Serializable> {

    /**
     * 新增一个
     * @param t
     * @return
     */
    T addOne(T t);

    /**
     * 根据ID删除
     * @param id
     */
    void deleteByID(ID id);

    /**
     *改
     */
    void update(T t);


    /**
     * 查找一个
     * @param id
     * @return
     */
    T findOne(ID id);

    /**
     * 查找所有
     * @return
     */
    List<T> findAll();


    /**
     * 分页查找
     */
    Page<T> findByPage(final T t, Pageable pageable);

}
