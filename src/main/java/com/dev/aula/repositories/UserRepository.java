package com.dev.aula.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.aula.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT obj FROM User obj WHERE obj.salary >= :minSalary AND obj.salary <= :maxSalary")
	Page<User> searchBySalary(Double minSalary, Double maxSalary, Pageable pageable);

	@Query("SELECT obj FROM User obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<User> searchByName(String name, Pageable pageable);

	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);
//Se escrever o nome com a nomenclatura do metódo correto ele já realiza a busca
	Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
