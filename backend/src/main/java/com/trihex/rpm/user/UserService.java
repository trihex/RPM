package com.trihex.rpm.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

/**
 * (c) Trihex Software LLC All Rights Reserved.
 */
@Service
public class UserService {
  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  Iterable<User> getAllUsers() {
    return repository.findAll();
  }

  User addUser(User user) {
    try {
      user.setRegistrationDate(new Timestamp(new Date().getTime()));
      return repository.save(user);
    } catch (UnexpectedRollbackException e) {
      return null;
    }
  }

  User getUser(int id) {
    return getUserById(id);
  }

  User updateUser(User user) {
    //Make sure user already exists
    User dbUser = getUserById(user.getId());

    if (dbUser == null)
      return null;

    return repository.save(user);
  }

  boolean deleteUser(int id) {
    User dbUser = getUserById(id);
    if (dbUser == null)
      return false;

    repository.deleteById(id);

    dbUser = getUserById(id);

    return dbUser == null;
  }

  private User getUserById(int id) {
    Optional<User> userOptional = repository.findById(id);

    return userOptional.orElse(null);
  }
}
