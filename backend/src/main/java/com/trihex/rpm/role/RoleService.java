package com.trihex.rpm.role;

import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class RoleService {

  final RoleRepository repository;

  public RoleService(RoleRepository repository) {
    this.repository = repository;
  }

  Iterator<Role> getForUser(int user) {
    return repository.getRoleByUser(user);
  }
}
