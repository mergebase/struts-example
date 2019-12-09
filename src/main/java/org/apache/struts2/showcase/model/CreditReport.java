package org.apache.struts2.showcase.model;

import java.io.Serializable;
import java.util.Date;


public class CreditReport implements IdEntity {

    private int reportId;
    private Date dateOfReport;
    private String givenName;
    private String surname;
    private String address;
    private String birthYear;
    private String birthDay;
    private String birthMonth;
    private String socialInsuranceNumber;
    private String creditRating;
    private String salary;


    public CreditReport()
    { }

    public CreditReport(int reportId,
                        String firstName,
                        String lastName,
                        String address,
                        String birthDay,
                        String birthMonth,
                        String birthYear,
                        String socialInsuranceNumber,
                        String creditRating,
                        String salary)
    {
        this.reportId = reportId;
        this.givenName = firstName;
        this.surname = lastName;
        this.address = address;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.socialInsuranceNumber = socialInsuranceNumber;
        this.creditRating = creditRating;
        this.salary = salary;
    }

    @Override
    public Serializable getId() {
        return getReportId();
    }

    @Override
    public void setId(Serializable id) {
        setReportId((int) id);
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public Date getDateOfReport() {
        return dateOfReport;
    }

    public void setDateOfReport(Date dateOfReport) {
        this.dateOfReport = dateOfReport;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getSocialInsuranceNumber() {
        return socialInsuranceNumber;
    }

    public void setSocialInsuranceNumber(String socialInsuranceNumber) {
        this.socialInsuranceNumber = socialInsuranceNumber;
    }

    public String getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    }

