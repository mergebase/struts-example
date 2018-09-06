package org.apache.struts2.showcase.dao;

import org.apache.struts2.showcase.application.DatabaseStorage;
import org.apache.struts2.showcase.application.Storage;
import org.apache.struts2.showcase.exception.CreateException;
import org.apache.struts2.showcase.exception.StorageException;
import org.apache.struts2.showcase.exception.UpdateException;
import org.apache.struts2.showcase.model.CreditReport;
import org.apache.struts2.showcase.model.IdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;

@Repository
public class CreditReportDao extends AbstractDao {
    private static final long serialVersionUID = 3294792301340971349L;

    @Autowired
    DatabaseStorage storage;

    @Override
    public Class getFeaturedClass() {
        return CreditReport.class;
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
        return storage.get(CreditReport.class, id);
    }

    @Override
    public Serializable create(IdEntity object) throws CreateException {
        return storage.create(object);
    }

    @Override
    public IdEntity update(IdEntity object) throws UpdateException {
        return storage.update(object);
    }

    @Override
    public Serializable merge(IdEntity object) throws StorageException {
        return storage.merge(object);
    }

    @Override
    public int delete(Serializable id) throws CreateException {
        return storage.delete(CreditReport.class, id);
    }

    @Override
    public int delete(IdEntity object) throws CreateException {
        return storage.delete(object);
    }

    @Override
    public Collection findAll() {
        return storage.findAll(CreditReport.class);
    }
}
