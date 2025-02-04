package com.felipedev.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipedev.dslist.dto.GameDTO;
import com.felipedev.dslist.dto.GameMinDTO;
import com.felipedev.dslist.entities.Game;
import com.felipedev.dslist.projections.GameMinProjection;
import com.felipedev.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {

		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}

	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {

		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
