package com.zaloni.training.service;

import java.util.List;

import com.zaloni.training.vo.TodoVo;


public interface TodoService {
	public TodoVo save(TodoVo todo);
	public TodoVo get(int todoId);
	public TodoVo update(TodoVo u);
	public boolean delete(int todoId);
	public List<TodoVo> list();
}
