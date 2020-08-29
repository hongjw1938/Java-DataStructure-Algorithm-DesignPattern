package com.problemsolve.bfs.webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    // BFS FIFO를 위한 Queue
    private Queue<String> queue;

    // 방문한 website list
    private List<String> discoverWebsitesList;

    public Webcrawler() {
        this.queue = new LinkedList<>();
        this.discoverWebsitesList = new ArrayList<>();
    }

    public void discoverWeb(String root){

        this.queue.add(root);
        this.discoverWebsitesList.add(root);

        while(!queue.isEmpty()){
            String v = this.queue.remove();
            String rawHtml = readURL(v);

            String regexp = "http://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(rawHtml);

            while(matcher.find()){
                String actualUrl = matcher.group();

                // 아직 방문하지 않을 url을 찾았다면
                if(!discoverWebsitesList.contains(actualUrl)){
                    discoverWebsitesList.add(actualUrl);
                    System.out.println("Website has been found with URL : " + actualUrl);
                    queue.add(actualUrl);
                }
            }
        }
    }

    private String readURL(String v){
        String rawHtml = "";
        try {

            // v로 전달된 URL로 open
            URL url = new URL(v);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine = "";

            // 읽을 것이 더 있다면 그것을 html에 계속 추가
            while((inputLine = br.readLine()) != null){
                rawHtml += inputLine;
            }
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return rawHtml;
    }
}
