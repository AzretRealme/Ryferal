package ryferal.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ryferal.models.Invite;
import ryferal.models.Subscriber;

import java.util.Date;
import java.util.Optional;

@Repository
public interface InviteRepo extends CrudRepository<Invite, Long> {
    long countAllBySenderAndStartDateAfter(Subscriber sender, Date date);
    Invite findByReceiver(Optional<Subscriber> receiver);

}
