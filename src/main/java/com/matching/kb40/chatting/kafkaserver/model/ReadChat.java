package com.matching.kb40.chatting.kafkaserver.model;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Alias("ReadChat")
public class ReadChat {
    private Long matchId;
    private String userId;
}
