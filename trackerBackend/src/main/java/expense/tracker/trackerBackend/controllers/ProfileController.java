package expense.tracker.trackerBackend.controllers;

import expense.tracker.trackerBackend.dao.UserRepository;
import expense.tracker.trackerBackend.entities.Profile;
import expense.tracker.trackerBackend.entities.User;
import expense.tracker.trackerBackend.service.interfaces.IProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private IProfile profileService;
    
    @Autowired
    private UserRepository userRepository;
    
    

    @GetMapping("/{userId}")
    public ResponseEntity<List<Profile>> getProfilesByUser(@PathVariable Long userId) {
        List<Profile> profiles = profileService.getProfilesByUserId(userId);
        return ResponseEntity.ok(profiles);
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        if (profile.getUser() != null && profile.getUser().getId() != null) {
            // Fetch the User entity based on user_id
            User user = userRepository.findById(profile.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + profile.getUser().getId()));

            // Associate the user with the profile
            profile.setUser(user);
        }

        Profile createdProfile = profileService.addProfile(profile);
        return ResponseEntity.ok(createdProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        Profile updatedProfile = profileService.updateProfile(id, profile);
        return ResponseEntity.ok(updatedProfile);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}
