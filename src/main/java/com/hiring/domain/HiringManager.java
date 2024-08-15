package com.hiring.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "hiringmanager")
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HiringManager {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dbky")
	private Long id;
	
	@Column(nullable = false,name = "hiring_manager_name")
	private String name;
	
	@Column(nullable = false,name = "hiring_manager_email")
	private String email;

}
