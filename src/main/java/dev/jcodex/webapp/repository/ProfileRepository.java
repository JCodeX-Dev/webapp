package dev.jcodex.webapp.repository;


import dev.jcodex.webapp.model.Header;
import dev.jcodex.webapp.model.Profile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, ObjectId> {
//    Profile findByUser(int user);

    Profile findByProfileId(int user);

//
}
