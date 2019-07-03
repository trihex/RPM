package com.trihex.rpm.outcome;

import org.springframework.data.repository.CrudRepository;

   public interface OutcomeRepository extends CrudRepository<Outcome, Integer> {
   Iterable<Outcome> findByPrimaryRole(int role);
}
