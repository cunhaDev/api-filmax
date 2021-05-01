package com.filmax.api.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.filmax.domain.model.Film;
import com.filmax.domain.reporitory.FilmRepository;
import com.filmax.domain.service.FilmAddService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping({ "/api" })
@Api(value = "Projeto Open Source Filmax")
@CrossOrigin(origins = "*")
public class FilmController {

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private FilmAddService addService;

	@GetMapping("/filmes")
	@ApiOperation(value = "Retorna uma Lista com Todos os Links Existentes.")
	public List<Film> Listing() {
		return filmRepository.findAll();
	}

	@PostMapping("/salvar")
	@ApiOperation(value = "Salva um Link no Repositório..")
	@ResponseStatus(HttpStatus.CREATED)
	public Film salvarFilme(@Valid @RequestBody Film filme){
		return addService.Add(filme);
	}
	
}
