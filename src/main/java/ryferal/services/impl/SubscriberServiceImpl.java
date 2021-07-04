package ryferal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ryferal.dao.SubscriberRepo;
import ryferal.exceptions.SubscriberNotFound;
import ryferal.mapper.SubscriberMapper;
import ryferal.models.Subscriber;
import ryferal.models.dto.SubscriberDto;
import ryferal.services.SubscriberService;

import java.util.Date;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepo subscriberRepo;

    @Autowired
    private SubscriberMapper subscriberMapper;


    @Override
    public SubscriberDto getOrCreate(SubscriberDto subscriberDto) {
        Subscriber subscriber = subscriberMapper.toSubscriber(subscriberDto);

        try {
            subscriber = subscriberRepo.findById(subscriber.getSubs_id())
                    .orElseThrow(() -> new SubscriberNotFound());
        }catch (SubscriberNotFound e){
            subscriber.setAddDate(new Date());
            subscriber.setEditDate(new Date());
            subscriber.setActive(true);
            subscriber = subscriberRepo.save(subscriber);
        }
        return subscriberMapper.toSubscriberDto(subscriber);
    }
}
