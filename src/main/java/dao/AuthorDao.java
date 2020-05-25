package dao;

import java.util.List;

import bean.Author;

public interface AuthorDao {
	//get all Author Info
	List<Author> getAllAuthor();
	
	//get one Author Info by ID
	Author getOneAuthor(int AuthorID);
	
	//insert
	
	boolean addAuthor(Author author);
	
	//delete
	boolean deleteAuthor(int authorID);
	
	//update
	boolean updateAuthor(Author author);

	List<Author> getAllAuthors();

}
