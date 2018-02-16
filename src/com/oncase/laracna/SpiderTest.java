package com.oncase.laracna;

public class SpiderTest {

	public static void main(String[] args) {
		Spider spider = new Spider();
        spider.search("https://www.abcdobebe.com/");
        for (String page : spider.getPagesVisited()) {
			System.out.println(page);
		}
	}

}
