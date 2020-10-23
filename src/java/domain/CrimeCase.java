/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author nizey
 */
public class CrimeCase {
    
    private String caseId = UUID.randomUUID().toString();
    private String crimeCommitted;
    private Date caseRegistration;
    private Date prisonerDateIn;
    private Date prisonerDateOut;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCrimeCommitted() {
        return crimeCommitted;
    }

    public void setCrimeCommitted(String crimeCommitted) {
        this.crimeCommitted = crimeCommitted;
    }

    public Date getCaseRegistration() {
        return caseRegistration;
    }

    public void setCaseRegistration(Date caseRegistration) {
        this.caseRegistration = caseRegistration;
    }

    public Date getPrisonerDateIn() {
        return prisonerDateIn;
    }

    public void setPrisonerDateIn(Date prisonerDateIn) {
        this.prisonerDateIn = prisonerDateIn;
    }

    public Date getPrisonerDateOut() {
        return prisonerDateOut;
    }

    public void setPrisonerDateOut(Date prisonerDateOut) {
        this.prisonerDateOut = prisonerDateOut;
    }
    
    
}
