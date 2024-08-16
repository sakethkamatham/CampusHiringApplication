package com.hiring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiring.domain.Notes;

@Repository
public interface NotesJpaRepository extends JpaRepository<Notes, Long> {

}
