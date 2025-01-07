package com.zxw.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    /**
     * 编码下载文件名以适应不同浏览器。
     *
     * @param filename 文件名
     * @param agent    User-Agent 请求头信息
     * @return 编码后的文件名
     */
    public static String encodeDownloadFilename(String filename, String agent) {
        try {
            if (agent == null) {
                agent = "";
            }
            // 对于IE或者Edge浏览器
            if (agent.contains("MSIE") || agent.contains("Trident") || agent.contains("Edge")) {
                String encodedFileName = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
                return "filename=" + encodedFileName;
            } else {
                // 对于其他浏览器（如Chrome、Firefox）
                return "filename*=UTF-8''" + URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("文件名编码失败", e);
        }
    }
}