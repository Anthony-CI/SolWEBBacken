package com.lectorium.service;

import java.util.List;

import com.lectorium.model.Publisher;

public interface IGenericService <T,ID>{
	T save(T t) throws Exception;
	T update(T t, ID id) throws Exception;
	List<T> findAll() throws Exception;
	T findById(ID id) throws Exception;
	void delete(ID id) throws Exception;
}
