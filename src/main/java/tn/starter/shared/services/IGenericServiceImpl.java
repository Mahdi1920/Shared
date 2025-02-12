package tn.starter.shared.services;

import java.util.List;

public class IGenericServiceImpl<T,ID> implements IGenericService<T,ID> {

	@Override
	public T add(T t) {
		return null;
	}

	@Override
	public T update(T t) {
		return null;
	}

	@Override
	public T retrieveById(ID id) {
		return null;
	}

	@Override
	public List<T> retrieveAll() {
		return null;
	}

	@Override
	public void delete(ID id) {

	}
}
