package com.yuandw.study;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.net.UnknownHostException;

@SpringBootApplication(
        exclude={DataSourceAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class})
@ImportResource(value = { "classpath*:applicationContext-bean.xml"})
@EnableRedisHttpSession
@ServletComponentScan
public class Bootstrap implements EmbeddedServletContainerCustomizer {
    @Value("${server.additional-ports}")
    String ports;
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication springApplication = new SpringApplication(Bootstrap.class);
        springApplication.setWebEnvironment(false);
        SpringApplication.run(Bootstrap.class, args);
        System.out.println("启动完成......");
    }

    @Override
    public void customize(
            ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        if (ports != null) {
          // 判断如果是Tomcat才进行如下配置
            if (configurableEmbeddedServletContainer instanceof TomcatEmbeddedServletContainerFactory) {
                // 转类型为TomcatEmbeddedServletContainerFactory
                TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) configurableEmbeddedServletContainer;

                String[] portsArray = ports.split(",");
                for (String portStr : portsArray) {
                    int port = Integer.parseInt(portStr);
                    // Tomcat中,一个Connecter监听一个端口
                    // 指定协议为HTTP/1.1
                    Connector httpConnector = new Connector("HTTP/1.1");
                    httpConnector.setPort(port);
                    tomcat.addAdditionalTomcatConnectors(httpConnector);
                }
            }
        }
    }

}
