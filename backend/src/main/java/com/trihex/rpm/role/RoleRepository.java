package com.trihex.rpm.role;

import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Iterator<Role> getRoleByUser(int user);
}
