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
public class VisitorVisitingPlan {
    
    private Date visitDate;
    private String relationship;
    private Date visitTime;

    private String visitorId;

    private String prisonVisitingPlanId;

    private String prisonerId;

    /**
     *
     * @return
     */
    public Date getVisitDate() {
        return visitDate;
    }

    /**
     *
     * @param visitDate
     */
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    /**
     *
     * @return
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     *
     * @param relationship
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    /**
     *
     * @return
     */
    public Date getVisitTime() {
        return visitTime;
    }

    /**
     *
     * @param visitTime
     */
    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    /**
     *
     * @return
     */
    public String getVisitorId() {
        return visitorId;
    }

    /**
     *
     * @param visitorId
     */
    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    /**
     *
     * @return
     */
    public String getPrisonVisitingPlanId() {
        return prisonVisitingPlanId;
    }

    /**
     *
     * @param prisonVisitingPlanId
     */
    public void setPrisonVisitingPlanId(String prisonVisitingPlanId) {
        this.prisonVisitingPlanId = prisonVisitingPlanId;
    }

    /**
     *
     * @return
     */
    public String getPrisonerId() {
        return prisonerId;
    }

    /**
     *
     * @param prisonerId
     */
    public void setPrisonerId(String prisonerId) {
        this.prisonerId = prisonerId;
    }
    
    
}
