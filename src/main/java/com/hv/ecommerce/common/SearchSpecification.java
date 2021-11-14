package com.hv.ecommerce.common;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SearchSpecification<T> implements Specification<T> {

    private SearchCriteria criteria;

    public SearchSpecification(SearchCriteria criteria){
        this.criteria =criteria;
    }

    @Override
    public Predicate toPredicate
            (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        // Equality
        if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getColumn()).getJavaType() == String.class) {
                return builder.like(
                        root.<String>get(criteria.getColumn()), "%" + criteria.getValue() + "%");
            }
        }
        return null;
    }
}
