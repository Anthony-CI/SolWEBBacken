package com.lectorium.service.impl;

import com.lectorium.model.Autor;
import com.lectorium.repo.IAuthorRepo;
import com.lectorium.repo.IGenericRepo;
import com.lectorium.service.IAuthorService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class AthorServiceImpl extends GenericServiceImpl<Autor, Integer>
                             implements IAuthorService {

	private final IAuthorRepo repo;

	@Override
	protected IGenericRepo<Autor, Integer> getRepo() {
		
		return repo;
	}
}
