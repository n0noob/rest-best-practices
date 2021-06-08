package com.learn.restbestpractices.models;

import lombok.*;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Quote {

    private Long id;

    private String quoteText;

    private Long authorId;

}
