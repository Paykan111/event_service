package com.netcracker.event.dto;

import lombok.Data;

@Data
public class ParticipantDto {
    private String fullName;
    private String userId;
    private String eventId;
    private boolean isTeamNeed;
}
