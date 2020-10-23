/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import domain.Prisoner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
public class SecurityGuardModel {
    
    private Prisoner prisoner = new Prisoner();
    private Prisoner[] prisoners = null;
    
    /**
     *
     */
    @PostConstruct
    public void init(){
        initPrisoner();
    }
    
    /**
     *
     */
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

            initPrisoner();
            
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Prisoner Registered"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     */
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
     * @return
     */
    public Prisoner getPrisoner() {
        return prisoner;
    }

    /**
     *
     * @param prisoner
     */
    public void setPrisoner(Prisoner prisoner) {
        this.prisoner = prisoner;
    }

    /**
     *
     * @return
     */
    public Prisoner[] getPrisoners() {
        return prisoners;
    }

    /**
     *
     * @param prisoners
     */
    public void setPrisoners(Prisoner[] prisoners) {
        this.prisoners = prisoners;
    }

}
