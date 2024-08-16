package com.hiring.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hiring.domain.University;

@Repository
public interface UniversityJpaRepository extends JpaRepository<University, Long>{

	@Query("SELECT u FROM University u WHERE LOWER(u.university_name) = LOWER(:name)")
	Optional<University> findByUniversityName(@Param("name") String university_name);

}
