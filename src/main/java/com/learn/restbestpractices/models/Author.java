package com.learn.restbestpractices.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Author {

    private Long id;

    private String fullName;

    private LocalDateTime dob;

    private String bioLink;

}
