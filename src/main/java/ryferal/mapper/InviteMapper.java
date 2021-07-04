package ryferal.mapper;


import ryferal.models.Invite;
import ryferal.models.dto.InviteDto;

public interface InviteMapper {

    Invite toInvite(InviteDto inviteDto);
    InviteDto toInviteDto(Invite invite);
}
