package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {
	
	Optional<UserDetails> findByEmailIdAndPassword(String username, String password);
	Optional<UserDetails> findByEmailId(String emailId);
}
