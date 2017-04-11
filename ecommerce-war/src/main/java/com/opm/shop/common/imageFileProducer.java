package com.opm.shop.common;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class imageFileProducer {
	
	@Named
	@Produces
	private String imgurl;
	
	@Named
	@Produces
	private String imgfilepath;
	
	@PostConstruct
	private void init(){
		imgurl=System.getProperty("ecommerce-war.image_url");
		imgfilepath=System.getProperty("ecommerce-war.img_file_path");
		
	}
	
	

}
