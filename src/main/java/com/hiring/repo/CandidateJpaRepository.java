package com.hiring.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiring.domain.Candidate;

@Repository
public interface CandidateJpaRepository extends JpaRepository<Candidate, Long> {

	Optional<Candidate> findByEmailAndName(String email, String name);

}
