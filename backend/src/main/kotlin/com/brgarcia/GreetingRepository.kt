package com.brgarcia

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
open class GreetingRepository @Autowired constructor(private val sessionFactory: SessionFactory) {

    @Transactional(readOnly = true)
    open fun all()
            = sessionFactory
            .currentSession
            .createQuery("from Greeting")
            .list()

    @Transactional
    open fun include(greeting: Greeting)
            = sessionFactory
            .currentSession
            .save(greeting)
}