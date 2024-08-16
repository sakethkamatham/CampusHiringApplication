package com.hiring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiring.domain.Recruiter;

@Repository
public interface RecruiterJpaRepository extends JpaRepository<Recruiter, Long>{

}
