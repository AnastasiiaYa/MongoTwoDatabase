package io.db.repository.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.db.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{}
