/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import domain.Admin;
import domain.CrimeCase;
import domain.PrisonVisitingPlan;
import domain.Prisoner;
import domain.SecurityGuard;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.json.JSONObject;

/**
 *
 * @author nizey
 */
@ManagedBean
@SessionScoped
public class AdminModel {
    
    private Admin admin = new Admin();
    private SecurityGuard securityGuard = new SecurityGuard();
    private Admin[] prisonAdmins = null;
    private SecurityGuard[] prisonSecurityGuards = null;
    private PrisonVisitingPlan plan = new PrisonVisitingPlan();
    private String startHour = new String();
    private String endHour = new String();
    private Prisoner prisoner = new Prisoner();
    private Prisoner[] prisoners = null;
    
    @PostConstruct
    public void init(){
        initAdmin();
        initGuard();
        initPrisoner();
    }
    
    public void registerAdmin() {
        try {
            URL url = new URL("http://localhost:9060/pvms/api/v1/prisons/admin");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject json = new JSONObject();
            json.put("nationalId", admin.getNationalId());
            json.put("firstName", admin.getFirstName());
            json.put("lastName", admin.getLastName());
            json.put("phone", admin.getPhone());
            json.put("email", admin.getEmail());
            json.put("gender", admin.getGender());
            json.put("prisonId", "13ddd6eb-b333-4729-978c-fa5f72f32b65");
            
            System.out.println(json.toString());
            OutputStream os = conn.getOutputStream();
            os.write(json.toString().getBytes());
            os.flush();

//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            conn.disconnect();

            System.out.println(response);

            initAdmin();
            
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Admin Registered, Find Email with credentials"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void registerPrisoner() {
        try {
            URL url = new URL("http://localhost:9060/pvms/api/v1/prisoners/add");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject json = new JSONObject();
            
            json.put("crimeCommitted", prisoner.getCrimeCommitted());
            json.put("prisonerDateIn", prisoner.getPrisonerDateIn());
            json.put("prisonerDateOut", prisoner.getPrisonerDateOut());
            
            json.put("nationalId", prisoner.getNationalId());
            json.put("firstName", prisoner.getFirstName());
            json.put("lastName", prisoner.getLastName());
            json.put("phone", prisoner.getPhone());
            json.put("email", prisoner.getEmail());
            json.put("gender", prisoner.getGender());
            
            json.put("prisonId", "13ddd6eb-b333-4729-978c-fa5f72f32b65");
            
            System.out.println(json.toString());
            OutputStream os = conn.getOutputStream();
            os.write(json.toString().getBytes());
            os.flush();

//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            conn.disconnect();

            System.out.println(response);

            initAdmin();
            
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Prisoner Registered"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void registerPrisonVisitingPlan() {
        try {
            URL url = new URL("http://localhost:9060/pvms/api/v1/prisons/prison-visit-plan");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date start = sdf.parse(startHour);
            Date end = sdf.parse(endHour);
            
            JSONObject json = new JSONObject();
            json.put("visitWeek", plan.getVisitWeek());
            json.put("totalPeopleVisitingInOneHour", plan.getTotalPeopleVisitingInOneHour());
//            json.put("startingHour", start);
//            json.put("endingHour", end);
            json.put("prisonId", "13ddd6eb-b333-4729-978c-fa5f72f32b65");
            
            System.out.println(json.toString());
            OutputStream os = conn.getOutputStream();
            os.write(json.toString().getBytes());
            os.flush();

//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            conn.disconnect();

            System.out.println(response);

            initAdmin();
            
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Visiting Plan Registered"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    public void registerGuard() {
        try {
            URL url = new URL("http://localhost:9060/pvms/api/v1/prisons/security-guard");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject json = new JSONObject();
            json.put("nationalId", securityGuard.getNationalId());
            json.put("firstName", securityGuard.getFirstName());
            json.put("lastName", securityGuard.getLastName());
            json.put("phone", securityGuard.getPhone());
            json.put("email", securityGuard.getEmail());
            json.put("gender", securityGuard.getGender());
            json.put("prisonId", "13ddd6eb-b333-4729-978c-fa5f72f32b65");
            
            System.out.println(json.toString());
            OutputStream os = conn.getOutputStream();
            os.write(json.toString().getBytes());
            os.flush();

//            if (conn.getResponseCode() != 200 || conn.getResponseCode() != 201) {
//                throw new IllegalArgumentException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
                        
            System.out.println("Output from Server .... \n");

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            conn.disconnect();

            System.out.println(response);

            initGuard();
            
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Security Guard Registered, Find Email with credentials"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     */
    public void initAdmin(){
        try {

            URL url = new URL("http://localhost:9060/pvms/api/v1/prisons/admins/13ddd6eb-b333-4729-978c-fa5f72f32b65");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            
            Gson g = new Gson();
            
            System.out.println("Output from Server .... \n");
            
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                prisonAdmins = g.fromJson(output, Admin[].class);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void initPrisoner(){
        try {

            URL url = new URL("http://localhost:9060/pvms/api/v1/prisoners/prison/13ddd6eb-b333-4729-978c-fa5f72f32b65");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            
            Gson g = new Gson();
            
            System.out.println("Output from Server .... \n");
            
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                prisoners = g.fromJson(output, Prisoner[].class);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     *
     */
    public void initGuard(){
        try {

            URL url = new URL("http://localhost:9060/pvms/api/v1/prisons/security-guards/13ddd6eb-b333-4729-978c-fa5f72f32b65");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            
            Gson g = new Gson();
            
            System.out.println("Output from Server .... \n");
            
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                prisonSecurityGuards = g.fromJson(output, SecurityGuard[].class);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     *
     * @param admin
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    /**
     *
     * @return
     */
    public SecurityGuard getSecurityGuard() {
        return securityGuard;
    }

    /**
     *
     * @param securityGuard
     */
    public void setSecurityGuard(SecurityGuard securityGuard) {
        this.securityGuard = securityGuard;
    }

    /**
     *
     * @return
     */
    public Admin[] getPrisonAdmins() {
        return prisonAdmins;
    }

    /**
     *
     * @param prisonAdmins
     */
    public void setPrisonAdmins(Admin[] prisonAdmins) {
        this.prisonAdmins = prisonAdmins;
    }

    /**
     *
     * @return
     */
    public SecurityGuard[] getPrisonSecurityGuards() {
        return prisonSecurityGuards;
    }

    /**
     *
     * @param prisonSecurityGuards
     */
    public void setPrisonSecurityGuards(SecurityGuard[] prisonSecurityGuards) {
        this.prisonSecurityGuards = prisonSecurityGuards;
    }

    public PrisonVisitingPlan getPlan() {
        return plan;
    }

    public void setPlan(PrisonVisitingPlan plan) {
        this.plan = plan;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public Prisoner getPrisoner() {
        return prisoner;
    }

    public void setPrisoner(Prisoner prisoner) {
        this.prisoner = prisoner;
    }

    public Prisoner[] getPrisoners() {
        return prisoners;
    }

    public void setPrisoners(Prisoner[] prisoners) {
        this.prisoners = prisoners;
    }

}
