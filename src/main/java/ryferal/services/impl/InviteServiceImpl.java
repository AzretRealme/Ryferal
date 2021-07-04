package ryferal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ryferal.dao.InviteRepo;
import ryferal.dao.SubscriberRepo;
import ryferal.exceptions.InviteLimitedReached;
import ryferal.mapper.InviteMapper;
import ryferal.mapper.SubscriberMapper;
import ryferal.models.Invite;
import ryferal.models.dto.InviteDto;
import ryferal.models.dto.SubscriberDto;
import ryferal.models.enums.InviteStatus;
import ryferal.services.InviteService;
import ryferal.services.SubscriberService;

import java.util.Calendar;

@Service
public class InviteServiceImpl implements InviteService {

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private InviteRepo inviteRepo;

    @Autowired
    private SubscriberMapper subscriberMapper;

    @Autowired
    private SubscriberRepo subscriberRepo;

    @Autowired
    private InviteMapper inviteMapper;

    @Override
    public InviteDto sendInvite(InviteDto inviteDto) {

        inviteDto.setSender(subscriberService.getOrCreate(inviteDto.getSender()));
        inviteDto.setReceiver(subscriberService.getOrCreate(inviteDto.getReceiver()));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        long count = inviteRepo.countAllBySenderAndStartDateAfter(
                subscriberMapper.toSubscriber(inviteDto.getSender()),
                calendar.getTime()
        );

        if(count == 5){
            throw new InviteLimitedReached("Достигнуто максимальное" +
                    "количество за сутки!");
        }
        if(!inviteDto.getReceiver().isActive()){
            throw new ArithmeticException("Абонент отключил возможность приглашения!");
        }
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        count = inviteRepo.countAllBySenderAndStartDateAfter(
                subscriberMapper.toSubscriber(inviteDto.getSender()),
                calendar.getTime()
        );

        System.out.println(inviteDto);
        return inviteDto;
    }

    @Override
    public SubscriberDto acceptInvite(Long subs_id) {

        return null;
    }
}
