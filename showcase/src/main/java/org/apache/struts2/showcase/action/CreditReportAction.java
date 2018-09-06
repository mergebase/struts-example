package org.apache.struts2.showcase.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.showcase.dao.CreditReportDao;
import org.apache.struts2.showcase.dao.Dao;
import org.apache.struts2.showcase.model.CreditReport;
import org.apache.struts2.showcase.model.IdEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CreditReportAction extends AbstractCRUDAction implements ModelDriven<CreditReport> {

    @Autowired
    private CreditReportDao creditReportDao;

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    private int reportId = 0;
    private CreditReport creditReport;




    public String execute() throws Exception {
        if(creditReport != null)
        {

        }
        return super.execute();
    }

    public String add() throws Exception {
        if(creditReport != null) {
            if(creditReport.getReportId() == 0)
            {
                Random random = new Random();
                int id = random.nextInt();
                creditReport.setReportId(id);
            }

            Date date = new Date();
            creditReport.setDateOfReport(date);

            CreditReport r = (CreditReport) creditReportDao.create(getCreditReport());

            setReportId(r.getReportId());

        }
        return SUCCESS;
    }


    @Override
    public CreditReport getModel() {
        return new CreditReport();
    }

    public CreditReport getCreditReport() {
        return creditReport;
    }

    public void setCreditReport(CreditReport creditReport) {
        this.creditReport = creditReport;
    }



    @Override
    protected Dao getDao() {
        return creditReportDao;
    }

    @Override
    public Collection getAvailableItems() {
        return creditReportDao.findAll();
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
