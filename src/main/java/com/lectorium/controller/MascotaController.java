package com.lectorium.controller;


import com.lectorium.dto.BookDTO;
import com.lectorium.dto.MascotaDTO;
import com.lectorium.model.Book;
import com.lectorium.model.Mascota;
import com.lectorium.service.IMascotaService;
import com.lectorium.service.IbookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/mascota")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MascotaController {

    private final IMascotaService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MascotaDTO>> findAll() throws Exception{
        List<MascotaDTO> list = service.findAll().stream().map(this::converToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> findById(@PathVariable Integer id) throws Exception{
        MascotaDTO obj = converToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody MascotaDTO dto) throws Exception{
        Mascota obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdMascota()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MascotaDTO> update(@PathVariable("id") Integer id,@RequestBody MascotaDTO dto) throws Exception{
        Mascota obj = service.update(convertToEntity(dto),id);
        MascotaDTO dto1= converToDto(obj);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)
            throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("hateoas/{id}")
    public EntityModel<MascotaDTO> findByIdHateoas(@PathVariable("id") Integer id) throws Exception{
        Mascota obj = service.findById(id);
        EntityModel<MascotaDTO> resource = EntityModel.of(converToDto(obj));
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findById(id));
        WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).findAll());
        resource.add(link1.withRel("mascota-self-info"));
        resource.add(link2.withRel("mascota-all-info"));

        return resource;
    }

    private MascotaDTO converToDto(Mascota obj){
        return modelMapper.map(obj, MascotaDTO.class);
    }

    private Mascota convertToEntity(MascotaDTO dto){
        return modelMapper.map(dto, Mascota.class);
    }

}
