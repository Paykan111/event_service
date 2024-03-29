package com.netcracker.event.dto;

import com.netcracker.event.domain.Event;
import com.netcracker.event.domain.Participant;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EventDto {
    private String name;
    private Date startDate;
    private String city;
    private String info;
    private String eventType;
    private String prize;
    private byte[] image;
    private Integer maxMemQuantity;
    private List<Participant> participantList;
    private String organizationId;

    private String organizationName;
}
