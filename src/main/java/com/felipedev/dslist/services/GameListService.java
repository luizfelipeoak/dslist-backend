package com.felipedev.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipedev.dslist.dto.GameListDTO;
import com.felipedev.dslist.entities.GameList;
import com.felipedev.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
}
