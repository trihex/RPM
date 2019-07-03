package com.trihex.rpm.outcome;

import org.springframework.stereotype.Service;

@Service
public class OutcomeService {

  private final OutcomeRepository repository;

  public OutcomeService(OutcomeRepository repository) {
    this.repository = repository;
  }

  Iterable<Outcome> getAllOutcomes() {
    return repository.findAll();
  }

  Iterable<Outcome> getOutcomesByRoll(int role) {
    return repository.findByPrimaryRole(role);
  }
}
