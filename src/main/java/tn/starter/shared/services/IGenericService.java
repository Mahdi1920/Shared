package tn.starter.shared.services;

import java.util.List;

public interface IGenericService<T,ID> {
	T add(T t);
	T update(T t);
	T retrieveById(ID id);
	List<T> retrieveAll();
	void delete(ID id);
}
