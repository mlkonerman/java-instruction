package db;

import java.util.List;

public interface DAO<T> {
	
	T get(int id);
	List<T> getAll();
	boolean add (T t); // T is type (User), t is variable name
	boolean update(T t);
	boolean delete(T t);
	

}
