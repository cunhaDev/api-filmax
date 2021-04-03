package com.filmax.domain.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmax.domain.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{

	Film findByTitulo(String titulo);
	
}
