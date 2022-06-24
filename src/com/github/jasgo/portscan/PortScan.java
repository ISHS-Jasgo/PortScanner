package com.github.jasgo.portscan;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class PortScan extends Thread {

    private final String ip;
    private final int port;
    private final int timeout;

    public PortScan(String ip, int port, int timeout) {
        this.ip = ip;
        this.port = port;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        Socket socket = null;
        SocketAddress address = new InetSocketAddress(ip, port);
        try {
            socket = new Socket();
            socket.connect(address, timeout);
            System.out.println("Open: " + port);
        } catch (IOException ignored) {
        }
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public int getTimeout() {
        return timeout;
    }
}
