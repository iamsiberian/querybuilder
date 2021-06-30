package com.example.querydslbuilder.core.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SearchCriteria {
    private final String key;
    private final SearchOperation operation;
    private final Object value;
}
