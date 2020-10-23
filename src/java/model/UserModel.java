package model;

import com.google.gson.Gson;
import domain.Account;
import domain.Admin;
import domain.Prison;
import domain.SecurityGuard;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.json.JSONObject;

@ManagedBean
@SessionScoped
public class UserModel {

    private JSONObject user;
    
    private Account account = new Account();

    private JSONObject guard;

    private JSONObject admin;

    private JSONObject prison;

    private String username = new String();

    private String password = new String();

    private String userdetails = new String();

    private String sid = new String();

    private String sectid = new String();

    private Account[] accounts = null;

    private Admin[] admins = null;

    private Prison[] prisons = null;

    private SecurityGuard[] securityGuards = null;

    public String login() throws IOException, Exception {
        findUser();
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        if (account != null) {

            if (user.getString("access").matches("Admin")) {
                System.out.println("Case 1:"+user.getString("access"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("session", account);
                ec.redirect(ec.getRequestContextPath() + "/pages/admin/admin.xhtml");
                return "pages/admin/admin.xhtml?faces-redirect=true";
            } else if (user.getString("access").matches("SecurityGuard")) {
                System.out.println("Case 2:"+user.getString("access"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("session", account);
                ec.redirect(ec.getRequestContextPath() + "/pages/security/prisoner.xhtml");
                return "pages/security/prisoner.xhtml?faces-redirect=true";
            } else {
                account = null;

                ec.redirect(ec.getRequestContextPath() + "/index.xhtml");

                return "/SDORG/index.xhtml";
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Wrong Password Or Username"));
            ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
            return "index.xhtml";
        }
    }

    public void findUser() {
        try {

            URL url = new URL("http://localhost:9060/pvms/api/v1/prisons/account/"+username+"/"+password);
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
                accounts = g.fromJson(output, Account[].class);

                for (Account p : accounts) {
                    account = p;
                    if (p.getAccess().matches("SecurityGuard")) {
                        output = output.replace("[", "").replace("]", "");
                        System.out.println(output);
                        JSONObject jSonObject = new JSONObject(output);
                        user = new JSONObject(output);
                        guard = jSonObject.getJSONObject("securityGuard");
                        prison = guard.getJSONObject("prison");
                        System.out.println(prison.getString("prisonName"));
                    } else if (p.getAccess().matches("Admin")) {
                        JSONObject jSonObject = new JSONObject(output);
                        user = new JSONObject(output);
                        admin = jSonObject.getJSONObject("admin");
                        prison = guard.getJSONObject("prison");
                    }
                }
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        account = null;
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(String userdetails) {
        this.userdetails = userdetails;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSectid() {
        return sectid;
    }

    public void setSectid(String sectid) {
        this.sectid = sectid;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Admin[] getAdmins() {
        return admins;
    }

    public void setAdmins(Admin[] admins) {
        this.admins = admins;
    }

    public Prison[] getPrisons() {
        return prisons;
    }

    public void setPrisons(Prison[] prisons) {
        this.prisons = prisons;
    }

    public SecurityGuard[] getSecurityGuards() {
        return securityGuards;
    }

    public void setSecurityGuards(SecurityGuard[] securityGuards) {
        this.securityGuards = securityGuards;
    }

    public JSONObject getUser() {
        return user;
    }

    public void setUser(JSONObject user) {
        this.user = user;
    }

    public JSONObject getGuard() {
        return guard;
    }

    public void setGuard(JSONObject guard) {
        this.guard = guard;
    }

    public JSONObject getAdmin() {
        return admin;
    }

    public void setAdmin(JSONObject admin) {
        this.admin = admin;
    }

    public JSONObject getPrison() {
        return prison;
    }

    public void setPrison(JSONObject prison) {
        this.prison = prison;
    }

}
