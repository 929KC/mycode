package com.kc.core;

import com.kc.utils.Resource;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 929KC
 * @date 2022/11/19 21:02
 * @description: 1.SqlSessionFactory构建器对象 ,通过build方法构建
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactoryBuilder() {
    }

    public SqlSessionFactory build(InputStream in) {
        SqlSessionFactory factory = null;
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(in);
            Element environments = (Element) document.selectSingleNode("/configuration/environments");
            String defaultEnv = environments.attributeValue("default");
            Element environment = (Element) document.selectSingleNode("/configuration/environments/environment[@id='" + defaultEnv + "']");
            //解析配置文件,创建数据源对象
            Element dataSourceElt = environment.element("dataSource");
            DataSource dataSource = getDataSource(dataSourceElt);
            //解析配置文件,创建事物管理器
            Element transcationManager = environment.element("transcationManager");
            Transaction transactionManager = getTransactionManager(transcationManager, dataSource);
            //解析配置文件,获取所有的SQL映射对象
            List<String> sqlMapperXMLPathList = new ArrayList<>();
            List<Node> nodes = document.selectNodes("//mapper");//获取整个文件所有的mapper标签
            nodes.forEach(node -> {
                Element mapper = (Element) node;
                String resouce = mapper.attributeValue("resouce");
                sqlMapperXMLPathList.add(resouce);
            });
            Map<String, MappedStatement> mappedStatements = getMappedStatements(sqlMapperXMLPathList);
            factory = new SqlSessionFactory(transactionManager, mappedStatements);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return factory;
    }

    private Map<String, MappedStatement> getMappedStatements(List<String> sqlMapperXMLPathList) {
        Map<String, MappedStatement> mappedStatements = new HashMap<String, MappedStatement>();
        sqlMapperXMLPathList.forEach(sqlMapperXMLPath -> {
            try {
                SAXReader reader = new SAXReader();
                Document document = reader.read(Resource.getResourcesAsStream(sqlMapperXMLPath));
                Element mapper = (Element) document.selectSingleNode("mapper");
                String namespace = mapper.attributeValue("namespace");
                List<Element> elements = mapper.elements();
                elements.forEach(element -> {
                    String id = element.attributeValue("id");
                    String sqlId = namespace + "." + id;
                    String resultType = element.attributeValue("resultType");
                    String sql = element.getTextTrim();
                    MappedStatement mappedStatement = new MappedStatement(sql, resultType);
                    mappedStatements.put(sqlId, mappedStatement);
                });
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        });
        return mappedStatements;
    }

    private Transaction getTransactionManager(Element transcationManager, DataSource dataSource) {
        String type = transcationManager.attributeValue("type").toUpperCase();
        Transaction transaction = null;
        if ("JDBC".equals(type)) {
            // 使用JDBC事务
            transaction = new JdbcTransaction(dataSource, false);
        } else if ("MANAGED".equals(type)) {
            // 事务管理器是交给JEE容器的
        }
        return transaction;
    }

    private DataSource getDataSource(Element dataSourceElt) {
        // 获取所有数据源的属性配置
        Map<String, String> dataSourceMap = new HashMap<>();
        dataSourceElt.elements().forEach(propertyElt -> {
            dataSourceMap.put(propertyElt.attributeValue("name"), propertyElt.attributeValue("value"));
        });

        String dataSourceType = dataSourceElt.attributeValue("type").toUpperCase();
        DataSource dataSource = null;
        if ("POOLED".equals(dataSourceType)) {

        } else if ("UNPOOLED".equals(dataSourceType)) {
            dataSource = new UnPooledDataSource(dataSourceMap.get("driver"), dataSourceMap.get("username"), dataSourceMap.get("password"), dataSourceMap.get("url"));
        } else if ("JNDI".equals(dataSourceType)) {

        }
        return dataSource;
    }
}
