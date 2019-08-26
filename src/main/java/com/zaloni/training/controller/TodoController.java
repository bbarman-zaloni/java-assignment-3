package com.zaloni.training.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zaloni.training.service.TodoService;
import com.zaloni.training.vo.TodoVo;

@Controller
public class TodoController {

    @Autowired
    @Qualifier("TodoService")
    TodoService todoService;

    // List -------------------------------------------------
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String redirectFromHome() {
        return "redirect:/todo/list";
    }

    @RequestMapping(value="/todo", method = RequestMethod.GET)
    public String redirectTodoList() {
        return "redirect:/todo/list";
    }

    @RequestMapping(value="/todo/list", method = RequestMethod.GET)
    public String getTodoList(ModelMap model) {
        model.put("todoList", todoService.list());
        return "todo-list";
    }
    
    // Create -------------------------------------------------
    @RequestMapping(value="/todo/add", method = RequestMethod.GET)
    public ModelAndView getTodoAddForm() {
        return new ModelAndView("todo-add", "todo", new TodoVo());
    }

    @RequestMapping(value="/todoAdd", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("todo")TodoVo todo, 
            BindingResult result, ModelMap model) {
        todoService.save((TodoVo) model.get("todo"));
        //return "success";
        return "redirect:/todo/list";
    }

    // Update -------------------------------------------------
    @RequestMapping(value="/todo/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getTodoEditForm(@PathVariable("id") int id) {
        TodoVo todoVo = todoService.get(id);
        return new ModelAndView("todo-edit", "todo", todoVo);
    }

    @RequestMapping(value="/todoEdit", method = RequestMethod.POST)
    public String editTodo(@Valid @ModelAttribute("todo")TodoVo todo, 
            BindingResult result, ModelMap model) {
        todoService.update((TodoVo) model.get("todo"));
        //return "success";
        return "redirect:/todo/list";
    }

    // Delete -------------------------------------------------
    @RequestMapping(value="/todo/delete/{id}", method = RequestMethod.GET)
    public ModelAndView getTodoDeleteForm(@PathVariable("id") int id) {
        TodoVo todoVo = todoService.get(id);
        return new ModelAndView("todo-delete", "todo", todoVo);
    }

    @RequestMapping(value="/todoDelete", method = RequestMethod.POST)
    public String deleteTodo(@Valid @ModelAttribute("todo")TodoVo todo, 
            BindingResult result, ModelMap model) {
        TodoVo todoVo = (TodoVo) model.get("todo");
        todoService.delete(todoVo.getId());
        //return "success";
        return "redirect:/todo/list";
    }

    // View -------------------------------------------------
    @RequestMapping(value="/todo/view/{id}", method = RequestMethod.GET)
    public String viewTodo(@PathVariable("id") int id, ModelMap model) {
        TodoVo todoVo = todoService.get(id);
        model.put("todo", todoVo);
        return "todo-view";
    }
}
