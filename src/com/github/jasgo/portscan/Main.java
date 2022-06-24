package com.github.jasgo.portscan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("대상 아이피를 입력해주세요");
            String ip = reader.readLine();
            System.out.println("스캔할 포트 범위를 입력해주세요. (ex: 1-10000)");
            String range = reader.readLine();

            String[] ports = range.split("-");
            if (!ports[0].equalsIgnoreCase(" ")) {
                int start = Integer.parseInt(ports[0]);
                int end = Integer.parseInt(ports[1]);
                for (int i = start; i <= end; i++) {
                    PortScan portScan = new PortScan(ip, i, 10);
                    portScan.start();
                }
                Thread.sleep(5000);
            }
        } catch (IOException | InterruptedException ignored) {
        }
    }
}
