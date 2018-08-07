package com.test.caravelo.persistence.repository;

import com.test.caravelo.persistence.model.Provider;
import com.test.caravelo.persistence.model.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider,String> {
}
