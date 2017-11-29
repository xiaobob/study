package study.bobo.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import study.bobo.domain.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Long>{
	
	Book findOne(Long id);
	
	 Book save(Book book);
	
	List<Book> findAll();
	
	@Query("select b from Book b where b.bookName like :name")
	List<Book> findByBookName(@Param("name") String name);
	
	@Query("select b from Book b where b.num =?")
	List<Book> findByNum(int num);
	
}
