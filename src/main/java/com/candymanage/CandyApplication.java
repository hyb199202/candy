package com.candymanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CandyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CandyApplication.class, args);
        //起socket服务
       /* SocketServer server = new SocketServer();
        server.startSocketServer(8088);*/

    }

}
