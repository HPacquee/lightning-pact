package be.ordina.hp.pact.queenslize.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, UUID> {
}
