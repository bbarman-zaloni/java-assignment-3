package com.zaloni.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.zaloni.training.entity.Todo;

@Repository
public class TodoDao {

	@PersistenceContext
    private EntityManager entityManger;

	@Transactional
	public void addTodo(Todo todo) {
		entityManger.persist(todo);
    }

	@Transactional
	public void deleteTodo(Todo todo) {
		if (!entityManger.contains(todo)) {
			Long id = todo.getId();
			todo = entityManger.find(Todo.class, id);
			if (todo == null) {
				throw new IllegalArgumentException("Todo with id :" + id + " not found");
			}
		}
		entityManger.remove(todo);
    }

	@Transactional
	public Todo getTodo(int id) {
		Long ID = new Long(id);
		Todo todo = entityManger.find(Todo.class, ID);
		return todo;
    }

	@Transactional
	public List<Todo> getTodoList() {
		TypedQuery<Todo> query = entityManger.createQuery("select t from Todo t", Todo.class);
		List<Todo> todoList = query.getResultList();
		return todoList;
	}

	@Transactional
	public Todo updateTodo(Todo todo) {
		Todo searchedTodo = entityManger.find(Todo.class, todo.getId());
		if (searchedTodo != null) {
			searchedTodo.setDescription(todo.getDescription());
			return searchedTodo;
		}
		return null;
    }
}
