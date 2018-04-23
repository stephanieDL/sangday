package configuration;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@PropertySource("classpath:core-${spring.profiles.active}.properties")
public class DataSourceConfiguration {

    private final static Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

    @ConfigurationProperties(prefix="datasource.sang", ignoreInvalidFields = true)
    @EnableConfigurationProperties
    @Configuration
    public static class SangDruidDataSourceConfig {

        private Map<String, String> config;

        @Bean(name = "sangDataSource")
        @Qualifier("sangDataSource")
        @Primary
        public DataSource primaryDataSource() throws Exception {
            logger.info("-------------------- datasource.sang init ---------------------");
            return DruidDataSourceFactory.createDataSource(config);
        }


        public Map<String, String> getConfig() {
            return config;
        }

        public void setConfig(Map<String, String> config) {
            this.config = config;
        }
    }

}
