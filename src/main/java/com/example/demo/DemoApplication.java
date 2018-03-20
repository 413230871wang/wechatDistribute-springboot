package com.example.demo;


import com.example.demo.bean.BookBean;
import com.example.demo.bean.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Value(value = "${books.author}")
	private String bookAuthor;
	@Value("${books.name}")
	private String bookName;
	@Value("${books.pinyin}")
	private String bookPinYin;
	@Autowired
	private BookBean bookBean;

	Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	@RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
	String index(){
		return "Hello Spring Boot! The BookName is "+bookName+";and Book Author is "+bookAuthor+";and Book PinYin is "+bookPinYin;
	}

	@RequestMapping("books")
	public String book(){
		logger.info("这是一个测试日志文件的日志！");
		return "Hello Spring Boot! The BookName is "+bookBean.getName()+";and Book Author is "+bookBean.getAuthor()+";and Book price is "+bookBean.getPrice();
	}

	@RequestMapping("/person_info")
	public ModelAndView index(ModelAndView model) {
		Person single = new Person("aa", 11);
		List<Person> people = new ArrayList<Person>();
		Person p1 = new Person("zhangsan", 114);
		Person p2 = new Person("lisi", 22);
		Person p3 = new Person("wangwu", 33);
		people.add(p1);
		people.add(p2);
		people.add(p3);
		model.addObject("singlePerson", single);
		model.addObject("people", people);
		model.setViewName("/index");
		return model;
	}
}
