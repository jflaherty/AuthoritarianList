package com.jayflaherty.AuthoritarianLists;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ListElement {
	
	Element listElement;
	Elements urls;
	
	public ListElement(Element listElement, Elements urls) {
		super();
		this.listElement = listElement;
		this.urls = urls;
	}
	
	public Element getListElement() {
		return listElement;
	}

	public Elements getUrls() {
		return urls;
	}

}
