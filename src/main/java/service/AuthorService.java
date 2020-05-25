package service;

import java.util.List;
import java.util.function.ObjIntConsumer;

import bean.Author;
import dao.AuthorDao;
import dao.AuthorDaoImpl;







public class AuthorService {
	
	private AuthorDao authorDao;

	public AuthorService() {
		
		authorDao = new AuthorDaoImpl();
	}
	
	
	//getAllAuthor
	public List<Author> getAllAuthors(){
		return authorDao.getAllAuthor();
	}
	
	//getOneAuthor
	public Author getOneAuthor(int authorID) {
		return authorDao.getOneAuthor(authorID);
	}
	
	//addAuthor
	public boolean addAuthor(Author author) {
		return authorDao.addAuthor(author);
	}
	
	
	//addAuthorWithLogic
	public Author createAuthor(String firstName, String lastName)  {
//		if(firstName==null||firstName.trim().isEmpty()||firstName.length()>30) {
//			throw  new IllegalArgumentException("first name cannot be null or longer than 30 ");
//		}
//		if(lastName==null||lastName.trim().isEmpty()||lastName.length()>30) {
//			throw  new IllegalArgumentException("last name cannot be null or longer than 30 ");
//		}
		
//		BiConsumer<Integer, String> validator = (length,value)->{
//			if(value==null||value.trim().isEmpty()||value.length()>length) {
//				throw  new IllegalArgumentException("first or last name cannot be null or longer than 30 ");
//			}	
//		};
//		
		//Lambda
		ObjIntConsumer<String> validator = (value,length)->{
			if(value==null||value.trim().isEmpty()||value.length()>length) {
				throw  new IllegalArgumentException("first or last name cannot be null or longer than 30 ");
			}	
		};
		
		validator.accept(firstName,30);
		validator.accept(lastName,30);
		
		return new Author(lastName,firstName);
		
	}
	
	
	
	//delete
	
	public boolean deleteAuthor(int authorID) {
		return authorDao.deleteAuthor(authorID);
		
	}
	
	
	//update
	public boolean  updateAuthor(Author author) {
		return authorDao.updateAuthor(author);
	}
	
	
	
	
	
	
	
	
	
	
	
}
