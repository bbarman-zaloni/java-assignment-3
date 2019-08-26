package com.zaloni.training.vo;

import com.zaloni.training.entity.Todo;

public class TodoVo {
	private int id;
	private String description;

	public TodoVo () {
	}

	public TodoVo (String description) {
		this.description = description;
	}

	public TodoVo (Todo todo) {
		this.id = todo.getId().intValue();
		this.description = todo.getDescription();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "id:"+this.id+",desc:"+this.description;
    }
}
