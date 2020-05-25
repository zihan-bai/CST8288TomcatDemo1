package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Author;



public class AuthorDaoImpl implements AuthorDao {
	private static final String SQL_GET_ALL_AUTHOR ="SELECT * FROM authors";
	private static final String SQL_GET_ONE_AUTHOR ="SELECT * FROM authors where AuthorID = ?";
	private static final String ADD_AUTHOR ="INSERT INTO authors (FirstName, LastName) values (?,?)";
	private static final String DELETE_AUTHOR ="DELETE FROM authors where AuthorID= ?";
	private static final String UPDATE_AUTHOR ="UPDATE authors set FirstName=?, LastName=? where AuthorID =?";

	//getAllAuthorInfo
	@Override
	public List<Author> getAllAuthors() {
		
		List<Author> list = new ArrayList<Author>();
		try (Connection con = DataSource.get();
			
				PreparedStatement statement = con.prepareStatement(SQL_GET_ALL_AUTHOR);
				ResultSet result = statement.executeQuery()) {
			
	
	
			while (result.next()) {
				list.add(new Author(result.getInt("AuthorID"), 
						            result.getString("FirstName"), 
						            result.getString("LastName")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	

	//add Author
	@Override
	public boolean addAuthor(Author author) {
		
		try (Connection con = DataSource.get();
				PreparedStatement statement = con.prepareStatement(ADD_AUTHOR);
			) {
			//set the ? 
			statement.setString(1, author.getfirstName());
			statement.setString(2, author.getlastName());
			
			//executeUpdate: return row counts that manipulate
			return statement.executeUpdate()>=1;
        		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
		
	}


	@Override
	public boolean deleteAuthor(int authorID) {
		try (Connection con = DataSource.get();
				PreparedStatement statement = con.prepareStatement(DELETE_AUTHOR);
			) {
			//set the ? 
			statement.setInt(1, authorID);
		
			
			//executeUpdate: return row counts that manipulate
			return statement.executeUpdate()>=1;
        		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
		
	}


	@Override
	public boolean updateAuthor(Author author) {
		try (Connection con = DataSource.get();
				PreparedStatement statement = con.prepareStatement(UPDATE_AUTHOR);
			) {
			//set the ? 
			statement.setString(1, author.getfirstName());
			statement.setString(2, author.getlastName());
			statement.setInt(3, author.getauthorID());
		
			
			//executeUpdate: return row counts that manipulate
			return statement.executeUpdate()>=1;
        		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
		
	}




	@Override
	public Author getOneAuthor(int AuthorID) {
		Author author = new Author();

		try (Connection con = DataSource.get();
				PreparedStatement statement = con.prepareStatement(SQL_GET_ONE_AUTHOR);
			) {
			//set the ? 
			statement.setInt(1, AuthorID);
			
			try(ResultSet result = statement.executeQuery()){
			
				if (result.next()) {
				  author = new Author(result.getInt("AuthorID"),result.getString("FirstName"),result.getString("LastName"));
				}
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return author;
	}




	@Override
	public List<Author> getAllAuthor() {
		List<Author> list = new ArrayList<Author>();
		try (Connection con = DataSource.get();
				PreparedStatement statement = con.prepareStatement(SQL_GET_ALL_AUTHOR);
				ResultSet result = statement.executeQuery()) {		
			while (result.next()) {
				list.add(new Author(result.getInt("AuthorID"), 
						            result.getString("FirstName"), 
						            result.getString("LastName")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}






}
