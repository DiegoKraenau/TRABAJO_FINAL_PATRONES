package Fabrica.Dao;

import java.util.ArrayList;

public interface CrudDAO<T>{
	public void save(T t);
	public void update(T t);
	public void delete(String cod);
	public T findById(String cod);
	public ArrayList<T> findAll();
}
