package com.example.biblio.Shared;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ErrorMessage {
    String message;
    Date timeStamp;
    Integer code;
}
