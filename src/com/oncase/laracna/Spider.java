package com.oncase.laracna;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Spider{
	private static final int MAX_PAGES_TO_SEARCH = 100;
	private Set<String> pagesVisited = new HashSet<String>();
	private List<String> pagesToVisit = new LinkedList<String>();



	public void search(String url) {
		String domain = url;
		boolean exit = false;
		while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH && !exit) {
			String currentUrl;
			SpiderLeg leg = new SpiderLeg();
			
			if(this.pagesToVisit.isEmpty()) {
				currentUrl = url;
				this.pagesVisited.add(url);
			}
			else{
				if(hasNext()) {
					currentUrl =  this.nextUrl();
				}else {
					exit = true;
					currentUrl = null;
				}
			}

			leg.crawl(currentUrl, domain); 
			this.pagesToVisit.addAll(leg.getLinks());
			System.out.println("Página visitada: " + currentUrl);
			if(this.pagesToVisit.size() == 44)
			System.out.println(pagesToVisit);
			System.out.println("Páginas para visitar: "+ this.pagesToVisit.size());
			System.out.println("Páginas para vistadas: "+ this.pagesVisited.size());
			if(this.pagesToVisit.size() == 0 && this.pagesVisited.size() > 0) {
				System.out.println("Vader");
				exit = true;
				break;
			}
			
		}
	}

	private boolean hasNext() {
		return (this.pagesToVisit.size() > 0);
	}

	private String nextUrl()
    {
        String nextUrl = null;
        do
        {
           if(this.hasNext()) {
        	   nextUrl = this.pagesToVisit.remove(0);
           }else {
        	   break;
           }
        	
        } while(this.pagesVisited.contains(nextUrl));
        if(this.hasNext()) {
        	this.pagesVisited.add(nextUrl);
        }
        
        return nextUrl;
    }


	public Set<String> getPagesVisited() {
		return pagesVisited;
	}

    public boolean validateDomain(String domain, String url) {
    	//String uD = urlDomain.split("//")[1];
    	//String domain = uD.split("/")[0];
    
    	if(url.contains(domain)) {
    		return true;
    	}
    	
    	return false;
    }

	public void setPagesVisited(Set<String> pagesVisited) {
		this.pagesVisited = pagesVisited;
	}
}