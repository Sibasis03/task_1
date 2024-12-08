package com.texium.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.texium.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
