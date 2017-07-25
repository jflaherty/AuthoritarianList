package com.jayflaherty.AuthoritarianLists;

import java.util.List;

import org.jsoup.select.Elements;

public class AuthoritarianList {

	private List<ListElement> listElements;
	private Elements metaProperties;

	public void setListElements(List<ListElement> listElements) {
		this.listElements = listElements;
		
	}

	public List<ListElement> getListElements() {
		return listElements;
	}

	public void setMetaProperties(Elements metaProperties) {
		this.metaProperties = metaProperties;		
	}
	
	public Elements getMetaProperties( ) {
		return this.metaProperties;
	}

}
