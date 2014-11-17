package edu.berkeley.path.scenario.dao;

import org.hibernate.Session;

import org.springframework.stereotype.Component;
/**
 *
 */

public interface HibernateSessionFactory {

    Session getSession();
}
