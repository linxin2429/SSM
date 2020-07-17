package com.xldeng.mybatis.io;

import java.io.InputStream;

/**
 * @author 邓鑫林
 * @since 2020/7/15 12:20
 */
public class Resources {
/**
 * @Description: 根据传入的参数获取字节输入流
 * @Author: xldeng
 * @Date: 2020/7/15 14:19
 * @param filePath:
 * @return: java.io.InputStream
 **/
    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}