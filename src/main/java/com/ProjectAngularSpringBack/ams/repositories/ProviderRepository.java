package com.ProjectAngularSpringBack.ams.repositories;

import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;
import com.ProjectAngularSpringBack.ams.entities.Provider;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {
}
