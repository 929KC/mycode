package com.kc.utils;




import java.io.InputStream;

/**
 * @author 929KC
 * @date 2022/11/19 20:53
 * @description: 读取类路径下的配置文件,并得到指向该文件的输入流
 */
public class Resource {
    /**
     *
     * @author 929KC
     * @date 2022/11/19 2022/11/19
     */

    private Resource(){

    }

    /**
     *
     * @author 929KC
     * @date 2022/11/19 2022/11/19
     * @param resource
     * @return InputStream
     */
    public static InputStream getResourcesAsStream(String resource) {
        return ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
    }

}
