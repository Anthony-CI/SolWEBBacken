package com.lectorium.service.impl;


import com.lectorium.model.Book;
import com.lectorium.model.Mascota;
import com.lectorium.repo.IBookRepo;
import com.lectorium.repo.IGenericRepo;
import com.lectorium.repo.IMascotaRepo;
import com.lectorium.service.IMascotaService;
import com.lectorium.service.IbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MascotaService extends GenericService<Mascota,Integer> implements IMascotaService {
    private final IMascotaRepo repo;
    @Override
    protected IGenericRepo<Mascota,Integer> getRepo() {
        return repo;
    }
}
