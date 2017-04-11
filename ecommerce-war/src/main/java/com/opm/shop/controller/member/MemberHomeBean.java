package com.opm.shop.controller.member;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import com.opm.shop.entity.Member;


@SuppressWarnings("serial")
public class MemberHomeBean implements Serializable {
   
    public MemberHomeBean() {
    }

    private Member members;

    @PostConstruct
    public void init() {
       
    }

    public String save() {
        return "";
    }

	public Member getMembers() {
		return members;
	}

	public void setMembers(Member members) {
		this.members = members;
	}
    
    

}