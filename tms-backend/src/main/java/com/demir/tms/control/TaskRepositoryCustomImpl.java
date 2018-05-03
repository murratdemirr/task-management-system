package com.demir.tms.control;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: muratdemir
 * Date: 3.05.2018
 * Time: 23:32
 */

@Repository
@Transactional(readOnly = true)
public class TaskRepositoryCustomImpl implements TaskRepositoryCustom {

    @PersistenceContext
    EntityManager em;

}
