package com.codingshuttle.jpaTutorial.jpaTuts.dto;

import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
