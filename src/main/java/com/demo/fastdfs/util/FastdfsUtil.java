package com.demo.fastdfs.util;

import com.demo.fastdfs.config.FastdfsClientConfig;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.sun.deploy.association.utility.AppConstants;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author ChenXS
 * fastdfs 工具类
 */
@Component
public class FastdfsUtil {
    @Autowired
    private FastFileStorageClient storageClient;

    /**
     * storage 服务器IP
     */
    @Value("${fdfs.storage-host}")
    private String host;

    /**
     * storage 服务器 端口
     */
    @Value("${fdfs.storage-port}")
    private String port;

    /**
     * 上传文件
     * @param file 待上传的文件
     * @return 上传后的文件地址
     * @throws IOException IOException
     */
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return getRealUrl(storePath);
    }

    /**
     * 上传文件 并 生成缩略图
     * @param file 待上传的文件
     * @return 上传后的文件地址
     * @throws IOException IOException
     */
    public String uploadImageAndCrtThumbImage(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return getRealUrl(storePath);
    }

    private String getRealUrl(StorePath storePath) {
        return "http://" + this.host + ":" + this.port + "/" + storePath.getFullPath();
    }

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
