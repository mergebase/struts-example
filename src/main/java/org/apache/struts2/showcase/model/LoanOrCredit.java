package org.apache.struts2.showcase.model;

import java.io.Serializable;

public class LoanOrCredit implements IdEntity {

    private float creditAmount;
    private boolean paidOnTime;
    private String dateOfLoan;


    @Override
    public Serializable getId() {
        return null;
    }

    @Override
    public void setId(Serializable id) {

    }
}
