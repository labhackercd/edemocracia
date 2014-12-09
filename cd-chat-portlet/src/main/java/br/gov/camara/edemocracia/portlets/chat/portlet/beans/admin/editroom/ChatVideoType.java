package br.gov.camara.edemocracia.portlets.chat.portlet.beans.admin.editroom;

import java.io.Serializable;

public enum ChatVideoType implements Serializable {
	WebCamara, wmv, flash, youtube; 
	
	
	public static ChatVideoType fromString(String str){
		if(str == null || str.equals("")){
			return null;
		}
		return valueOf(str);
	}
}
