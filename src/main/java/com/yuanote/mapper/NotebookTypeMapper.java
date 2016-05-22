package com.yuanote.mapper;

import java.util.List;

import com.yuanote.domain.NotebookType;

public interface NotebookTypeMapper {
    
    NotebookType selectByPrimaryKey(Long sid);
    
    List<NotebookType> selectByCriteria(NotebookType record); 
    
}