package com.example.querydslbuilder.core.service.querydsl;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SearchCriteria {
    private final String key;
    private final String operation;
    private final Object value;
}
