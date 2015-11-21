package com.espe.distribuidas.pmaldito.jclient.controler;

/**
 *
 * @author Luig Rocha
 */
public class login {
    private String user;
    private String pass;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "login{" + "user=" + user + ", pass=" + pass + '}';
    }
    
    
}
