package com.mybatisAndTransaction.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Spring Framwork가 구동될 때,
 * @Configuration 파일들을 찾아서 설정값을 초기화한다.
 * @Configuration 파일들은 각 파일의 Bean 내용들을 토대로 초기값을 설정해준다.
 * @Bean 들은 싱글턴 패턴으로 spring framework에 등록된다.
 * 
 * hikariConfig() 메소드는 hikari cp config을 spring framework에 명시해준다.  
 * spring.datasource.hikari는 application.yml에 명시된 내용이다.
 * 
 * dataSource() 메소드는 hikariConfig()의 리턴값을 dataSource로 등록한다.
 * dataSource를 설정함으로써 myBatis가 hikari dbcp(DataBaseConnectionPool)을 활용할 수 있도록 연결해주는 것이다.
 * 
 * sqlSessionFactory(dataSource)는 spring framework에 등록된 dataSource를 매개변수로 받아서,
 * sqlSessionFactoryBean을 설정하고 그 객체를 spring framework에 등록한다.
 *  - sqlSessionFactoryBean에 매개변수로 받은 myBatis dataSource를 등록한다.
 *  - sqlSessionFactoryBean에 쿼리문이 저장된 xml을 매핑하여 해당 쿼리를 활용할 수 있도록한다.
 *  
 * sqlSessionTemplate에 sqlSessionFactory를 등록하여 sqlSessionTemplate을 spring framework에 등록한다.
 * 
 * @author minhj
 *
 */
@Configuration
public class OracleDBConfiguration {	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
	@ConfigurationProperties("spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}//hikari cp config을 명시
	
	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		
		return dataSource;
	}//mybatis에 hikari cp 등록

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlFactoryBean = new SqlSessionFactoryBean();
		
		sqlFactoryBean.setDataSource(dataSource);
		sqlFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/**.xml"));
		
		return sqlFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
