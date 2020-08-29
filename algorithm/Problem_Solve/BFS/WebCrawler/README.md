### Web Crawler
- <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/tree/master/Algorithm/Problem_Solve/BFS/WebCrawler/App.java">App.java</a>
    - 해당 코드는 Web Crawler를 실행하기 위한 Main method 구현 코드

- <a href="https://github.com/hongjw1991/Java-DataStructure-Algorithm-DesignPattern/tree/master/Algorithm/Problem_Solve/BFS/WebCrawler/WebCrawler.java">WebCrawler.java</a>
    - Web Crawler를 BFS 방식으로 구현한 Code이다.
    - 해당 코드에는 정규 표현식을 통해 URL Pattern을 지정하고 해당 URL Pattern과 일치하는 Value를 HTML Source에서 Matcher를 통해 찾아낸다.
    - Matcher를 통해 못 찾을 때까지 계속 찾고 각각 찾은 subsequence group을 기존에 방문한 이웃 List에 있는지 검사한 다음, 없는 경우 List에 추가하고 Queue에 추가하여 다음에 방문할 대상으로 지정한다.
    - 이와 같이, 계속하여 이웃 URL을 찾아낼 수 있다.
    - 결과 값에 오류가 나온다면, Server에 접속하지 못했거나, Network 문제 등 다양한 이유로 발생할 수 있으니 크게 신경쓰지 않아도 된다.(실전에서 사용 시엔 해당 Exception을 처리해야 함)