package com.oncase.laracna;

public class SpiderTest {

	public static void main(String[] args) {
		Spider spider = new Spider();
        spider.search("http://www2.zelo.com.br/");
        for (String page : spider.getPagesVisited()) {
			System.out.println(page);
		}
	}

}
