package org.apache.struts2.showcase.dao;

import org.apache.struts2.showcase.application.Storage;
import org.apache.struts2.showcase.exception.CreateException;
import org.apache.struts2.showcase.exception.StorageException;
import org.apache.struts2.showcase.exception.UpdateException;
import org.apache.struts2.showcase.model.IdEntity;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;

@Repository
public class CreditReportDao extends AbstractDao {
    private static final long serialVersionUID = 3294792301340971349L;

    @Override
    public Class getFeaturedClass() {
        return null;
    }

    @Override
    public Storage getStorage() {
        return super.getStorage();
    }

    @Override
    public void setStorage(Storage storage) {
        super.setStorage(storage);
    }

    @Override
    public IdEntity get(Serializable id) {
        return super.get(id);
    }

    @Override
    public Serializable create(IdEntity object) throws CreateException {
        return super.create(object);
    }

    @Override
    public IdEntity update(IdEntity object) throws UpdateException {
        return super.update(object);
    }

    @Override
    public Serializable merge(IdEntity object) throws StorageException {
        return super.merge(object);
    }

    @Override
    public int delete(Serializable id) throws CreateException {
        return super.delete(id);
    }

    @Override
    public int delete(IdEntity object) throws CreateException {
        return super.delete(object);
    }

    @Override
    public Collection findAll() {
        return super.findAll();
    }
}
