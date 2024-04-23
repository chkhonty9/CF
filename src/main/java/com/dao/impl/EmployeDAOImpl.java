package com.dao.impl;

import com.dao.EmployeDAO;
import com.entity.Employe;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeDAOImpl extends HibernateDaoSupport implements EmployeDAO {

    @Autowired
    public void setUpSessionFactory(SessionFactory sessionFactory) {
        System.out.println("Setting up SessionFactory");
        this.setSessionFactory(sessionFactory);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Employe o) {
        System.out.println("saving employe");
        this.getHibernateTemplate().saveOrUpdate(o);
    }

    @Override
    @Transactional
    public void delete(Employe o) {
        System.out.println("deleting employee");
        this.getHibernateTemplate().delete(o);
    }

    @Override
    public Employe getById(int id) {
        return this.getHibernateTemplate().get(Employe.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employe> getAll() {
        return (List<Employe>) this.getHibernateTemplate().findByCriteria(
                DetachedCriteria.forClass(Employe.class));
    }
}
