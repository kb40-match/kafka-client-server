package com.matching.kb40.chatting.kafkaserver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NewChat {
    private Long matchId;
    private String userId;
    private String content;
    private String createdDate;
}
