package com.vti.be.specification;


import com.vti.be.entity.Account;
import com.vti.be.form.AccountFilterForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AccountSpecification {
    public static Specification<Account> buildSpec (AccountFilterForm form) {
        return (root, query, builder) -> {
            if (form == null) {
                return null;
            }
            List<Predicate> predicates = new ArrayList<>() ;

            return  builder.and(predicates.toArray(new Predicate[0])) ;
        };
    }
}
