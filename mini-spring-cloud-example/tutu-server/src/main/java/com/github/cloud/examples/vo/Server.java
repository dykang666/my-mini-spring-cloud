package com.github.cloud.examples.vo;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/8/10 16:08
 */
public class Server {
    private String ip;

    private Integer port;

    public Server(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public Integer getPort() {
        return port;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Server server = (Server) o;

        if (!ip.equals(server.ip)){
            return false;
        }
        return port.equals(server.port);
    }

    @Override
    public int hashCode() {
        int result = ip.hashCode();
        result = 31 * result + port.hashCode();
        return result;
    }

}
