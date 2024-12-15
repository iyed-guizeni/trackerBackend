package expense.tracker.trackerBackend.service.interfaces;

import expense.tracker.trackerBackend.entities.Profile;

import java.util.List;

public interface IProfile{
    Profile addProfile(Profile profile);
    Profile updateProfile(Long id, Profile profile);
    void deleteProfile(Long id);
    Profile getProfileById(Long id);
    List<Profile> getProfilesByUserId(Long userId);
}
