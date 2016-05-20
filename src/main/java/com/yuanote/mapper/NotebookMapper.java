package com.yuanote.mapper;

import java.util.List;

import com.yuanote.domain.Notebook;

public interface NotebookMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(Notebook record);

    int insertSelective(Notebook record);

    List<Notebook> selectByPrimaryKey(Long sid);
    
    List<Notebook> selectByCriteria(Notebook notebook);

    int updateByPrimaryKeySelective(Notebook record);

    int updateByPrimaryKeyWithBLOBs(Notebook record);

    int updateByPrimaryKey(Notebook record);
}