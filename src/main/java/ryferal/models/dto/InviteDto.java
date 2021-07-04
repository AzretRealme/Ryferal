package ryferal.models.dto;


import lombok.Data;
import ryferal.models.Subscriber;
import ryferal.models.enums.InviteStatus;

import javax.persistence.*;
import java.util.Date;

@Data
public class InviteDto {

    private Long id;

    SubscriberDto sender;

    SubscriberDto receiver;

    private Date startDate;
    private Date endDate;

    private InviteStatus status;

}
