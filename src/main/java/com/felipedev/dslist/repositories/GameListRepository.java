package com.felipedev.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipedev.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
