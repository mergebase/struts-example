package org.apache.struts2.showcase.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.showcase.dao.CreditReportDao;
import org.apache.struts2.showcase.dao.Dao;
import org.apache.struts2.showcase.model.CreditReport;
import org.apache.struts2.showcase.model.IdEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;

public class CreditReportAction extends AbstractCRUDAction {

    @Autowired
    private CreditReportDao creditReportDao;

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    private Long reportId;
    private CreditReport creditReport;


    public String execute() throws Exception {
        if(creditReport != null)
        {

        }
        return super.execute();
    }

    public String save() throws Exception {
        if(creditReport != null) {
            setReportId((Long) creditReportDao.merge(getCreditReport()));

        }
        return SUCCESS;
    }

    public CreditReport getCreditReport() {
        return creditReport;
    }

    public void setCreditReport(CreditReport creditReport) {
        this.creditReport = creditReport;
    }



    @Override
    protected Dao getDao() {
        return null;
    }

    @Override
    public Collection getAvailableItems() {
        return super.getAvailableItems();
    }

    @Override
    public String[] getToDelete() {
        return super.getToDelete();
    }

    @Override
    public void setToDelete(String[] toDelete) {
        super.setToDelete(toDelete);
    }

    @Override
    public String list() throws Exception {
        return super.list();
    }

    @Override
    public String delete() throws Exception {
        return super.delete();
    }

    @Override
    protected IdEntity fetch(Serializable tryId, IdEntity tryObject) {
        return super.fetch(tryId, tryObject);
    }
}
