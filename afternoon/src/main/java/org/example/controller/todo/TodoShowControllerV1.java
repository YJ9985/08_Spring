package org.example.controller.todo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class TodoShowControllerV1 {
    private TodoDtoListV1 todoDtoList = TodoDtoListV1.getInstance();

    @GetMapping("/todo/show")
    public String process(HttpServletRequest request) {
        log.info("==============> Todo 목록 조회 페이지 호출, /todo/show");

        request.setAttribute("todoList", todoDtoList.getList());
        return "todo-show";
    }
}
