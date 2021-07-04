package ryferal.services;

import ryferal.models.dto.InviteDto;
import ryferal.models.dto.SubscriberDto;

public interface InviteService {

    InviteDto sendInvite(InviteDto inviteDto);

    SubscriberDto acceptInvite(Long subs_id);
}
