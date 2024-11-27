package com.texium.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texium.entity.Profile;
import com.texium.service.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@GetMapping
	public ResponseEntity<List<Profile>> getAllProfiles() {
		List<Profile> profiles = profileService.getAllProfiles();
		return ResponseEntity.ok(profiles);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
		Optional<Profile> profile = profileService.getProfileById(id);
		return profile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile) {
		Profile savedProfile = profileService.saveProfile(profile);
		return ResponseEntity.ok(savedProfile);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
		Profile updatedProfile = profileService.saveProfile(profile);
		return ResponseEntity.ok(updatedProfile);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProfileById(@PathVariable Long id) {
		profileService.deleteProfileById(id);
		return ResponseEntity.noContent().build();
	}

}
