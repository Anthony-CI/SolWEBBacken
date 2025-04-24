package com.lectorium.service.impl;

import java.util.List;

import com.lectorium.repo.IGenericRepo;
import com.lectorium.service.IGenericService;

public abstract class  GenericServiceImpl <T,ID> implements IGenericService<T, ID> {

	protected abstract IGenericRepo<T, ID> getRepo();
	
	@Override
	public T save(T t) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().save(t);
	}

	@Override
	public T update(T t, ID id) throws Exception {
		// todo identificar id de la entidad
		return getRepo().save(t);
	}

	@Override
	public List<T> findAll() throws Exception {
		// TODO Auto-generated method stub
		return getRepo().findAll();
	}

	@Override
	public T findById(ID id) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void delete(ID id) throws Exception {
		getRepo().deleteById(id);
		
	}
	
}
