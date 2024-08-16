package com.hiring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiring.domain.HiringManager;

@Repository
public interface HiringManagerJpaRepository extends JpaRepository<HiringManager, Long> {

}
