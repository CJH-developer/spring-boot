package com.simple.basic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 부가적인 Bean 설정은 아래와 같이 하면 된다.


@Configuration // Spirng 설정 파일
//java resource 경로 참조, properties를 스프링의 properties파일로 등록하고 안에 들어 있는 키 값들을 참조해서 사용이 가능해진다.
@PropertySource("classpath:/application.properties")  
public class WebConfig implements WebMvcConfigurer{
//	
//	@Autowired
//	ApplicationContext applicationContext;
//	
//	// 1. hikari config 객체 생성
//	// spring.datasource.hikari로 시작하는 설정 정보를 읽어와서 메서드에 적용
//	@ConfigurationProperties(prefix = "spring.datasource.hikari")
//	@Bean
//	public HikariConfig config() {
//		
//		return new HikariConfig();
//	}
//	
//	// 2. 데이터 소스 객체 생성 ( config 의존성 주입 )
//	@Bean
//	public DataSource DataSource() {
//		return new HikariDataSource(config());
//	}
//	
//	// 3. 세션 팩토리 빈 설정 ( 인터페이스 xml 구현체를 만들고 관리 )
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//		bean.setDataSource(dataSource);
//		
////		부가 설정
//		bean.setTypeAliasesPackage("com.simple.basic.command");
//		bean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));
//		
//		return bean.getObject();
//	}
//	@Bean
//	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}
	
	
	
//	//Spring의 Bean들을 전역적으로 관리하는 IOC 기반의 bean 관리하는 객체
//	@Autowired
//	ApplicationContext context;
//	
//	// application-properties 내의 키를 들고온다. ( DB 설정이나, 포트를 이용할 때 활용 )
//	@Value("${server.port}")
//	String port;
//	
//	@Value("${a}")
//	String bye;
//	
//	@Bean // Spring이 실행할 때 이 Method를 실행시켜서 반환되는 값을 bean으로 등록한다.
//	void hello() {
//		System.out.println("포트 번호 : " + port);
//		System.out.println("두 번째 properties 설정 값 : " + bye);
//		
//		// DI
//		HomeController controller = context.getBean(HomeController.class);
//		System.out.println(controller);
//		
//		// Bean 수량 
//		int cnt = context.getBeanDefinitionCount();
//		String[] arr = context.getBeanDefinitionNames();
//		System.out.println(cnt);
//		//System.out.println(Arrays.toString(arr));
//	}
}
