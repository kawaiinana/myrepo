package com.opm.shop.common;

import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.opm.shop.entity.Member;
import com.opm.shop.service.AccountServiceLocal;

@Model
@SuppressWarnings("serial")
public class SecurityLoginBean implements Serializable{
    
    public SecurityLoginBean() {
    }
    
    private String name;
    private String email;
    private String password;
    private Event event;
    
    @Inject
    private AccountServiceLocal service;
    
    public String login() {
    	try {
			
			ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest req = (HttpServletRequest) ctx.getRequest();
			
			System.out.println("It's in the try block.");
			
			req.login(email, password);
			
			if(req.isUserInRole("Admin")) {
				return "/admin/home?faces-redirect=true";
			}
			
			return "/member/my-profile?faces-redirect=true";
				
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("Login Error", "Please check your Email and Password!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
    	System.out.println("Login is called.");
    	return "";
    }

    public String signUp() {
    	
    	Member m = new Member();
    	m.setNickname(name);
    	m.setEmail(email);
    	m.setPassword(password);
    	
    	service.create(m);
    	
        return login();
    }

    public String logout() {
    	
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		ctx.invalidateSession();
		return "/index?faces-redirect=true";
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}