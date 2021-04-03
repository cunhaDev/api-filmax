package com.filmax.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.filmax.domain.model.Film;
import com.filmax.domain.reporitory.FilmRepository;
import com.filmax.domain.service.FilmAddService;

@RestController
@RequestMapping({"/film"})
public class FilmController {
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private FilmAddService addService;
	
	@GetMapping
	public List<Film> Listing(){
		return filmRepository.findAll();
	}

	@PostMapping("/addfilm")
	@ResponseStatus(HttpStatus.CREATED)
	public Film AddingNew(@Valid @RequestBody Film film){
		return addService.Add(film);
	}
}
