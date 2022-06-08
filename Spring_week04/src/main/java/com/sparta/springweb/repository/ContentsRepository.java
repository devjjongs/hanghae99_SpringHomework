package com.sparta.springweb.repository;

import com.sparta.springweb.model.Contents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ContentsRepository extends JpaRepository<Contents, Long> {
    List<Contents> findAllByOrderByCreatedAtDesc();
}