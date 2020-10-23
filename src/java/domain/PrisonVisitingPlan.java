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
public class PrisonVisitingPlan {
    
    private int visitWeek;
    private int totalPeopleVisitingInOneHour;
    private Date startingHour;
    private Date endingHour;

    private String prisonId;

    /**
     *
     * @return
     */
    public int getVisitWeek() {
        return visitWeek;
    }

    /**
     *
     * @param visitWeek
     */
    public void setVisitWeek(int visitWeek) {
        this.visitWeek = visitWeek;
    }

    /**
     *
     * @return
     */
    public int getTotalPeopleVisitingInOneHour() {
        return totalPeopleVisitingInOneHour;
    }

    /**
     *
     * @param totalPeopleVisitingInOneHour
     */
    public void setTotalPeopleVisitingInOneHour(int totalPeopleVisitingInOneHour) {
        this.totalPeopleVisitingInOneHour = totalPeopleVisitingInOneHour;
    }

    /**
     *
     * @return
     */
    public Date getStartingHour() {
        return startingHour;
    }

    /**
     *
     * @param startingHour
     */
    public void setStartingHour(Date startingHour) {
        this.startingHour = startingHour;
    }

    /**
     *
     * @return
     */
    public Date getEndingHour() {
        return endingHour;
    }

    /**
     *
     * @param endingHour
     */
    public void setEndingHour(Date endingHour) {
        this.endingHour = endingHour;
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
