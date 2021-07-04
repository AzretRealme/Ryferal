package ryferal.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ryferal.models.Subscriber;

@Repository
public interface SubscriberRepo extends CrudRepository<Subscriber, Long> {
}
