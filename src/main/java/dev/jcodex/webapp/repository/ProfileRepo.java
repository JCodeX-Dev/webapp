package dev.jcodex.webapp.repository;

import dev.jcodex.webapp.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProfileRepo extends JpaRepository<Profile,Integer> {
}
