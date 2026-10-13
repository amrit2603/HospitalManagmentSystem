package com.codingshuttle.jpaTutorial.jpaTuts.dto;

import com.codingshuttle.jpaTutorial.jpaTuts.entity.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
