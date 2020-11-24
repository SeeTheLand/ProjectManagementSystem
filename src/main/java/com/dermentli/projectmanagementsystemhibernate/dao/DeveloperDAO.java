package com.dermentli.projectmanagementsystemhibernate.dao;

import com.dermentli.projectmanagementsystemhibernate.domain.Developer;
import com.dermentli.projectmanagementsystemhibernate.domain.Language;

import javax.persistence.EntityManager;
import java.util.List;

public class DeveloperDAO extends GenericDAO<Developer, Long> {

    @Override
    public Class<Developer> getEntityClass() {
        return Developer.class;
    }

    public List<Developer> getDevsByLanguage(String language) {
        EntityManager em = getEntityManager();
        List<Developer> developersList = em.createQuery("FROM " + Developer.class + " WHERE " + Language.class.getName().equals(language)).getResultList();
        em.close();
        return developersList;
    }
}