package com.filmax.api.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.filmax.domain.model.Film;
import com.filmax.domain.reporitory.FilmRepository;
import com.filmax.domain.service.FilmAddService;
import com.filmax.domain.upload.FileUploadUtil;

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
	public String salvarUsuario(@Valid Film filme, @RequestParam("profilePictureFile") MultipartFile multipartFile1) //recebe o arquivo pelo mulyipart
			throws IOException {

		String profilePictureFileName = StringUtils.cleanPath(multipartFile1.getOriginalFilename()); // armazena em uma varivel

		filme.setFoto(profilePictureFileName); //manda pra variavel foto(do model filme)

		Film savedFilme = addService.Add(filme); //salva no banco
		String uploadDir = "filmes/" + savedFilme.getId(); //salva em uma pasta local

		FileUploadUtil.saveFile(uploadDir, profilePictureFileName, multipartFile1); //delega pro arquivo fileUploadUtil salvar uma copia Local

		return "filme cadastrado com sucesso!"; //retorna uma msg dizendo que foi salvo, caso dÊ certo
	}
}
