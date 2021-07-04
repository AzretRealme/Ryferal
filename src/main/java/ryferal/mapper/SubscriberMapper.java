package ryferal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ryferal.models.Subscriber;
import ryferal.models.dto.SubscriberDto;

public interface SubscriberMapper {


    Subscriber toSubscriber(SubscriberDto subscriberDto);
    SubscriberDto toSubscriberDto(Subscriber subscriber);
}
