package ryferal.mapper.impl;

import org.springframework.stereotype.Service;
import ryferal.mapper.SubscriberMapper;
import ryferal.models.Subscriber;
import ryferal.models.dto.SubscriberDto;

@Service
public class SubscriberMapperImpl implements SubscriberMapper {
    @Override
    public Subscriber toSubscriber(SubscriberDto subscriberDto) {
        Subscriber subscriber = new Subscriber();
        subscriber.setSubs_id(subscriberDto.getSubs_id());
        subscriber.setPhone(subscriberDto.getPhone());
        subscriber.setAddDate(subscriberDto.getAddDate());
        subscriber.setEditDate(subscriberDto.getEditDate());
        subscriber.setActive(subscriberDto.isActive());
        return subscriber;
    }

    @Override
    public SubscriberDto toSubscriberDto(Subscriber subscriber) {
        SubscriberDto subscriberDto = new SubscriberDto();
        subscriberDto.setSubs_id(subscriber.getSubs_id());
        subscriberDto.setPhone(subscriber.getPhone());
        subscriberDto.setAddDate(subscriber.getAddDate());
        subscriberDto.setEditDate(subscriber.getEditDate());
        subscriberDto.setActive(subscriber.isActive());
        return subscriberDto;
    }
}
