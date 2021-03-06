package sitemap;
import java.net.*;
import java.io.*;
import org.jsoup.*;
import org.jsoup.examples.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.parser.*;
import org.jsoup.safety.*;
import org.jsoup.select.*;
import java.util.Collection;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Sitemap {
		
    public static void main(String args[]) {
	    	Scanner input = new Scanner(System.in);
	    	String base;
		System.out.println("What is the base URL?");
		base = input.nextLine();
		System.out.println("Generating . . .");
	    	Set<String> scanned = new HashSet<String>();
		Set<String> newLinks = new HashSet<String>(genSitemap(base,base)); //base href <a> tags index.html
		Set<String> incScanned = new HashSet<String>();
		List<List<String>> pages = new ArrayList<List<String>>();

		do{ 				
		
	 	for(String a : newLinks) {  // load base links, get <a> href for each
			scanned.add(a);
			System.out.println(a);
			incScanned.addAll(genSitemap(a,base));
		}	

		for (String a : scanned) {
			//System.out.println(a);
			pages.add(getImgs(a));
		}
		
		

		newLinks.addAll(incScanned); // update base href list w/ found links
		newLinks.removeAll(scanned); // remove links which are already scanned
		} while (newLinks.size()!=0); // repeat scan/filter until no new links found


		
		for (List page : pages) {
			String[] ary = ((List<String>)page).toArray(new String[page.size()]);
			for (String src : ary) {
				System.out.println(src);
			}
		}
		try {
		PrintWriter writer = new PrintWriter("sitemap.xml","UTF-8");
		writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		writer.println("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\"");
		writer.println("xmlns:image=\"http://www.google.com/schemas/sitemap-image/1.1\">");
		for (List page : pages) {
			writer.println("<url>");
			writer.println("<loc>"+page.get(0)+"</loc>");
			page.remove(0);
			String[] ary = ((List<String>)page).toArray(new String[page.size()]);
			for (String src : ary) {
				writer.println("");
				writer.println("<image:image>");
				writer.println("<image:loc>"+src.replace("../","")+"</image:loc>");
				writer.println("</image:image>");
			}
		writer.println("</url>");
		}
		writer.println("</urlset>");

		writer.close();
		} catch(Exception e) {
			System.out.println(e);
		}
    }
    public static List genSitemap(String mapUrl, String base) {
	    try {
	    Document doc = Jsoup.connect(mapUrl).get();
	    Elements links = doc.select("a");
	    Elements imgs = doc.select("img");
	    List<String> stringLinks = new ArrayList<String>();
	    for (Element link : links) {
		stringLinks.add(link.attr("abs:href"));
	    }

		Iterator<String> domIt = stringLinks.iterator(); // filter out links to external domains
		while(domIt.hasNext()) {
			String incDom = domIt.next();
			boolean domTest;
			domTest = incDom.contains(base);
			if(domTest==false) {
				domIt.remove();
			}
		}
		Iterator<String> i = stringLinks.iterator(); 
		while(i.hasNext()) {	// remove index.html from incoming links prevents infinite loop
				String incA = i.next();
				if(incA.contains("index")) {
					i.remove();
				}
		}

	    return stringLinks;
	    } catch(Exception e) {
		    //System.out.println(e);
		    return null;
	    }
    }
    public static List getImgs(String mapUrl) {
	try {
		Document doc = Jsoup.connect(mapUrl).get();
		Elements imgs = doc.select("img");
		List<String> stringImgs = new ArrayList<String>();
		stringImgs.add(mapUrl);
		for (Element img : imgs) {
			String imgSrc = img.attr("abs:src");
			if(imgSrc.contains("paypal")==false)
				stringImgs.add(imgSrc);
		}
		return stringImgs;
	} catch(Exception e) {
		System.out.println(e);
		return null;
	}
    }
}
