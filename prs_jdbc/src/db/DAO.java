package db;

import java.util.List;

public interface DAO<T> {
	
	T get(int ID);
	List<T> getAll();
	boolean add (T t); // T is type (Stuffy), t is variable name
	boolean update(T t);
	boolean delete(T t);
	

}
