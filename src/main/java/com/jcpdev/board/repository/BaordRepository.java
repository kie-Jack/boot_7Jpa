package com.jcpdev.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcpdev.board.entity.Board;

public interface BaordRepository extends JpaRepository<Board, Long>{

	
}
