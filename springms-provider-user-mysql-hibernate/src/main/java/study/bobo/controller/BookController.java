package study.bobo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import study.bobo.dao.BookDao;
import study.bobo.domain.Book;

@RestController
public class BookController {
	@Autowired
	private BookDao dao;
	
	@GetMapping("/{id}")
	public Book findOne(@PathVariable("id")Long id){
		return dao.findOne(id);
	}
	
	@GetMapping("/all")
	public List<Book> findOne(){
		return dao.findAll();
	}
	
	@GetMapping("/save")
	public Book saveBook(){
		Book book=new Book();
		book.setBookName("saveBook");
		book.setNum(20);
		dao.save(book);
		return book;
	}
	
	@GetMapping("/name")
	public List<Book> findByBookName(String name){
		return dao.findByBookName(name);
	}
	
	@GetMapping("/num")
	public List<Book> findByNum(int num){
		System.out.println(num);
		return dao.findByNum(num);
	}
}
