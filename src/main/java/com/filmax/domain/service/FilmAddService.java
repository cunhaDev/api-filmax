package com.filmax.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmax.domain.exception.Exception;
import com.filmax.domain.model.Film;
import com.filmax.domain.reporitory.FilmRepository;

@Service
public class FilmAddService {
	
	@Autowired
	private FilmRepository filmRepository;
	
	public Film Add(Film film) {
		
		Film filmExist = filmRepository.findByTitulo(film.getTitulo());
		
		if(filmExist != null && !filmExist.equals(film)) {
			throw new Exception("Ops! Já existe este Titulo...");
		}
		
		return filmRepository.save(film); 
	}

}
