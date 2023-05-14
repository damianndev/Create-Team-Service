package com.example.mecz.controller.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LineUpDto{

    private Integer lineupNumber;
    private String lineupName;
}
