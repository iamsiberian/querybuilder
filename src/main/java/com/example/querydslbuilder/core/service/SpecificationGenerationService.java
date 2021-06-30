package com.example.querydslbuilder.core.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class SpecificationGenerationService {

    public <T> EntitySpecification<T> getEntitySpecificationFrom(
            String key, String stringSearchOperation, String value
    ) {
        if (key == null || value == null) {
            // logger or app exception
            return null;
        }

        SearchCriteria criteria;

        try {
            SearchOperation searchOperation = Enum.valueOf(
                    SearchOperation.class, stringSearchOperation
            );
            criteria = new SearchCriteria(
                    key, searchOperation, value
            );
        } catch (IllegalArgumentException e) {
            // logger or app exception
            return null;
        }

        return new EntitySpecification<T>(
                criteria
        );
    }
}
