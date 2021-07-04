package ryferal.models;


import lombok.Data;
import ryferal.models.enums.InviteStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "invites")
public class Invite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    Subscriber sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    Subscriber receiver;

    private Date startDate;
    private Date endDate;

    @Enumerated(EnumType.STRING)
    private InviteStatus status;

}
