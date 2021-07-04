package ryferal.services;

import ryferal.models.dto.SubscriberDto;

public interface SubscriberService {

    SubscriberDto getOrCreate(SubscriberDto subscriberDto);
}
