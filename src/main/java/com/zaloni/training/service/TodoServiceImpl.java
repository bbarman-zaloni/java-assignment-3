package com.zaloni.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaloni.training.dao.TodoDao;
import com.zaloni.training.entity.Todo;
import com.zaloni.training.vo.TodoVo;

@Service("TodoService")
public class TodoServiceImpl implements TodoService {
	@Autowired
	TodoDao todoDao;

	@Override
	public TodoVo save(TodoVo todoVo) {
	    Todo todo = new Todo();
	    todo.setDescription(todoVo.getDescription());
    	todoDao.addTodo(todo);
    	todoVo.setId(todo.getId().intValue());
    	return todoVo;
	}

	@Override
	public TodoVo get(int todoId) {
	    TodoVo todo;
	    Todo t = todoDao.getTodo(todoId);
		todo = (t == null) ? null : new TodoVo(t);
		return todo;
	}

	@Override
	public TodoVo update(TodoVo todoVo) {
	    Todo todo = new Todo();
		todo.setId(new Long(todoVo.getId()));
		todo.setDescription(todoVo.getDescription());
		todo = todoDao.updateTodo(todo);
		return (todo == null) ? null : new TodoVo(todo);
	}

	@Override
	public boolean delete(int todoId) {
		Todo todo = new Todo(todoId);
		try {
			todoDao.deleteTodo(todo);
		}
		catch (IllegalArgumentException iae) {
			return false;
		}
		return true;
	}

	@Override
	public List<TodoVo> list() {
		List<TodoVo> list = new ArrayList<TodoVo>();
		List<Todo> todoList =  todoDao.getTodoList();
		for (Todo t:todoList) {
			list.add(new TodoVo(t));
		}

		return list;
	}

}
