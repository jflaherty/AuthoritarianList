package com.jayflaherty.AuthoritarianLists.Parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import com.jayflaherty.AuthoritarianLists.AuthoritarianList;
import com.jayflaherty.AuthoritarianLists.ListElement;

public class ParseWeeklyAuthoritarianList {
	
	File inputFile;

	public ParseWeeklyAuthoritarianList(File inputFile) {
		super();
		this.inputFile = inputFile;
	}
	
	public AuthoritarianList parseHtml() throws IOException {
		AuthoritarianList weeklyList = new AuthoritarianList();
		List<ListElement> listElements = new ArrayList<ListElement>();
		Document doc = Jsoup.parse(inputFile, "UTF-8", "https://medium.com/@Amy_Siskind");
		weeklyList.setListElements(listElements);
		weeklyList.setMetaProperties(doc.select("meta[property]"));
		return weeklyList;
	}


}
