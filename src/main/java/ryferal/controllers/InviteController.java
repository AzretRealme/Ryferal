package ryferal.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ryferal.models.dto.InviteDto;
import ryferal.services.InviteService;

@RestController
@RequestMapping("api/v1/invite")
public class InviteController {

    @Autowired
    private InviteService inviteService;

    @PostMapping("/send")
    public InviteDto send(@RequestBody InviteDto inviteDto){
        return inviteService.sendInvite(inviteDto);
    }

    @PostMapping("/accept")
    public InviteDto accept(@RequestParam Long subs_id) {

        return null;
    }

}
