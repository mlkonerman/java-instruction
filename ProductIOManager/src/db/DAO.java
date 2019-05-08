package db;

import java.util.List;

public interface DAO<T> {
	
	T get(String code);
	List<T> getAll();
	boolean add (T t); // T is type (Product), t is variable name
	boolean update(T t);
	boolean delete(T t);
	

}
