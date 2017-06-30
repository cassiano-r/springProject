package br.com.cassiano.springproject.generic;

import java.util.List;

public interface JPAGenreric<T> {
	
	T findById(Integer id);
			
	List<T> findAll();
	
	void save(T t);
	
	T update(T t);
	
	void delete(T t);

}
