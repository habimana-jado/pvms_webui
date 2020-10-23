/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author nizey
 */
public class Prisoner {
    
    private String crimeCommitted;
    private Date prisonerDateIn;
    private Date prisonerDateOut;

    private String nationalId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String gender;

    private String prisonId;

    /**
     *
     * @return
     */
    public String getCrimeCommitted() {
        return crimeCommitted;
    }

    /**
     *
     * @param crimeCommitted
     */
    public void setCrimeCommitted(String crimeCommitted) {
        this.crimeCommitted = crimeCommitted;
    }

    /**
     *
     * @return
     */
    public Date getPrisonerDateIn() {
        return prisonerDateIn;
    }

    /**
     *
     * @param prisonerDateIn
     */
    public void setPrisonerDateIn(Date prisonerDateIn) {
        this.prisonerDateIn = prisonerDateIn;
    }

    /**
     *
     * @return
     */
    public Date getPrisonerDateOut() {
        return prisonerDateOut;
    }

    /**
     *
     * @param prisonerDateOut
     */
    public void setPrisonerDateOut(Date prisonerDateOut) {
        this.prisonerDateOut = prisonerDateOut;
    }

    /**
     *
     * @return
     */
    public String getNationalId() {
        return nationalId;
    }

    /**
     *
     * @param nationalId
     */
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     */
    public String getPrisonId() {
        return prisonId;
    }

    /**
     *
     * @param prisonId
     */
    public void setPrisonId(String prisonId) {
        this.prisonId = prisonId;
    }
    
    
    
}
