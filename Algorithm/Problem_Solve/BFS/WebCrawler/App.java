package com.problemsolve.bfs.webcrawler;

public class App {

    public static void main(String[] args){
        Webcrawler crawler = new Webcrawler();

        String rootUrl = "http://www.google.com";

        crawler.discoverWeb(rootUrl);
    }
}