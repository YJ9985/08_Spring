package org.example.controller.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

@Controller
@Slf4j
@RequiredArgsConstructor
@Transactional
@RequestMapping*("/book/jpa")
public class JpaBookController {

}
