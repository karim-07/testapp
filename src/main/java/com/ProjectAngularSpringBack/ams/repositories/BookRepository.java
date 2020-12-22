package com.ProjectAngularSpringBack.ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ProjectAngularSpringBack.ams.entities.Book;




@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	
	
}
