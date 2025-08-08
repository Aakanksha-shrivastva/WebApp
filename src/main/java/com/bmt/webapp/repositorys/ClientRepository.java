package com.bmt.webapp.repositorys;

import com.bmt.webapp.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    // custom methods if needed
}
