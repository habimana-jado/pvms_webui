/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.UUID;

/**
 *
 * @author nizey
 */
public class Prison {
    
    private String prisonId = UUID.randomUUID().toString();
    private String prisonName;
    private String visitingHours;
    private String email;
    private String phoneNumber;
    
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

    /**
     *
     * @return
     */
    public String getPrisonName() {
        return prisonName;
    }

    /**
     *
     * @param prisonName
     */
    public void setPrisonName(String prisonName) {
        this.prisonName = prisonName;
    }

    /**
     *
     * @return
     */
    public String getVisitingHours() {
        return visitingHours;
    }

    /**
     *
     * @param visitingHours
     */
    public void setVisitingHours(String visitingHours) {
        this.visitingHours = visitingHours;
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
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
}
