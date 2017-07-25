package com.jayflaherty.AuthoritarianLists.Parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jayflaherty.AuthoritarianLists.AuthoritarianList;
import com.jayflaherty.AuthoritarianLists.ListElement;

public class ParseWeeklyAuthoritarianList {
	
	File listDirectory;

	public ParseWeeklyAuthoritarianList(File listDirectory) {
		super();
		this.listDirectory = listDirectory;
	}
	
	public Collection<File> getHtmlFiles() {		
		Collection<File> files = FileUtils.listFiles(listDirectory,
		         FileFilterUtils.suffixFileFilter(".html"), TrueFileFilter.INSTANCE);
		return files;
	}
	
	public void parseFiles() throws IOException {
		Collection<File> files = getHtmlFiles();
		for(File file : files) {
			parseHtml(file);
		}
	}
	
	public AuthoritarianList parseHtml(File htmlFile) throws IOException {
		AuthoritarianList weeklyList = new AuthoritarianList();
		List<ListElement> listElements = new ArrayList<ListElement>();
		Document doc = Jsoup.parse(htmlFile, "UTF-8", "https://medium.com/@Amy_Siskind");
		Elements listTags = doc.select("ol li");
		for (Element listTag : listTags) {
			Elements urls = listTag.select("a");
			listElements.add(new ListElement(listTag, urls));
		}
		weeklyList.setListElements(listElements);
		weeklyList.setMetaProperties(doc.select("meta[property]"));
		return weeklyList;
	}


}
