package com.demo.fastdfs.action;

import com.demo.fastdfs.util.FastdfsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenXS
 * fastdfs Controller
 */
@RestController
@RequestMapping("/fastdfs")
public class FastdfsAction {
    @Autowired
    private FastdfsUtil fastdfsUtil;

    @RequestMapping("upLoad")
    public Map<String, Object> upLoad(MultipartFile files) {
        Map<String, Object> map = new HashMap<>();
        try {
            String filePath = fastdfsUtil.uploadImageAndCrtThumbImage(files);
            map.put("filePath", filePath);
            map.put("isSuccess", true);
        } catch (IOException e) {
            map.put("isSuccess", false);
            e.printStackTrace();
        }
        return map;
    }
}
