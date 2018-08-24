package org.apache.struts2.showcase.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CreditReport implements IdEntity {

    private Long reportId;
    private Date dateOfReport;
    private String givenName;
    private String surname;
    private String address;
    private Long birthYear;
    private Long birthDay;
    private Long birthMonth;
    private String socialInsuranceNumber;
    private int creditRating;
    private float salary;
    private List<LoanOrCredit> loansAndCredit;


    public CreditReport()
    { }

    public CreditReport(Long reportId,
                        String firstName,
                        String lastName,
                        String address,
                        Long birthDay,
                        Long birthMonth,
                        Long birthYear,
                        String socialInsuranceNumber,
                        int creditRating,
                        float salary,
                        List<LoanOrCredit> loanOrCredits)
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
        this.loansAndCredit = loanOrCredits;
    }

    @Override
    public Serializable getId() {
        return getReportId();
    }

    @Override
    public void setId(Serializable id) {
        setReportId((Long) id);
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
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

    public Long getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Long birthYear) {
        this.birthYear = birthYear;
    }

    public Long getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Long birthDay) {
        this.birthDay = birthDay;
    }

    public Long getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Long birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getSocialInsuranceNumber() {
        return socialInsuranceNumber;
    }

    public void setSocialInsuranceNumber(String socialInsuranceNumber) {
        this.socialInsuranceNumber = socialInsuranceNumber;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public List<LoanOrCredit> getLoansAndCredit() {
        return loansAndCredit;
    }

    public void setLoansAndCredit(List<LoanOrCredit> loansAndCredit) {
        this.loansAndCredit = loansAndCredit;
    }
}
