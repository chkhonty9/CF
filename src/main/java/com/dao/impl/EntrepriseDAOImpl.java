package com.dao.impl;

import com.dao.EntrepriseDAO;
import com.entity.Entreprise;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class EntrepriseDAOImpl extends HibernateDaoSupport implements EntrepriseDAO {

    @Autowired
    public void setUpSessionFactory(SessionFactory sessionFactory) {
        System.out.println("Setting up SessionFactory");
        this.setSessionFactory(sessionFactory);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Entreprise o) {
        System.out.println("saving Entreprise");
        this.getHibernateTemplate().saveOrUpdate(o);
    }

    @Override
    @Transactional
    public void delete(Entreprise o) {
        System.out.println("deleting Entreprise");
        this.getHibernateTemplate().delete(o);
    }

    @Override
    public Entreprise getById(int id) {
        System.out.println("getting by id Entreprise");
        return this.getHibernateTemplate().get(Entreprise.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Entreprise> getAll() {
        System.out.println("getting All Entreprise");

        return (List<Entreprise>) this.getHibernateTemplate().findByCriteria(
                DetachedCriteria.forClass(Entreprise.class));
    }
}
