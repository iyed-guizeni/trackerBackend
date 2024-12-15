package expense.tracker.trackerBackend.service.implement;

import expense.tracker.trackerBackend.dao.ProfileRepository;
import expense.tracker.trackerBackend.entities.Profile;
import expense.tracker.trackerBackend.service.interfaces.IProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileImplement implements IProfile {

    @Autowired
    private ProfileRepository profileRepository;
    
    

    @Override
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(Long id, Profile profile) {
        Profile existingProfile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found with id: " + id));
        // Update fields
        existingProfile.setProfileName(profile.getProfileName());
        existingProfile.setProfileType(profile.getProfileType());
        existingProfile.setDescription(profile.getDescription());
        return profileRepository.save(existingProfile);
    }


    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public Profile getProfileById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    @Override
    public List<Profile> getProfilesByUserId(Long userId) {
    	List<Profile> profiles = profileRepository.findByUserId(userId);

        // Handle null or empty cases (if needed)
        if (profiles == null) {
            return List.of(); // Return an empty list instead of null
        }

        return profiles;
    }
}
