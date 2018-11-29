package com.demo.fastdfs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ChenXS
 * FastDFS 客户端配置
 */
@Component
public class FastdfsClientConfig {

    /**
     * 服务器地址
     */
    private String host;

    /**
     * 服务器端口
     */
    private String port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
