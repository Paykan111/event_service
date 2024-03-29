package com.netcracker.event.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "event")
@NoArgsConstructor
public class Event {
    @Id
    @Column(name = "event_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy ="org.hibernate.id.UUIDGenerator")
    private UUID eventId;
    @Column(name = "name")
    @NonNull
    private String name;
    @Column(name = "start_date")
    @NonNull
    private Date startDate;
    @Column(name = "city")
    @NonNull
    private String city;
    @Column(name = "info")
    private String info;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private EventType eventType;
    @Column(name = "prize")
    private String prize;
    @Column(name = "image")
    private byte[] image;
    @Column(name = "max_mem_quantity")
    private Integer maxMemQuantity;
    @Column(name = "organization_name")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eventId")
    @JsonIgnore
    private List<Participant> participantList;
//    @ManyToMany(mappedBy = "eventList")
//    @JsonIgnore
//    private List<Organization> organizationList;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organizationId;

}