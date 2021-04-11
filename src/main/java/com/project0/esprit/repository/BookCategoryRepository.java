package com.project0.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project0.esprit.datentity.BookCategory;

@Repository
//@RepositoryRestResource(collectionResourceRel="bookCateogry", path="book-category")
public interface BookCategoryRepository  extends JpaRepository<BookCategory, Long>{

}
