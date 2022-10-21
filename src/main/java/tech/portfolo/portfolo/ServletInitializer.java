package tech.portfolo.portfolo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Servletinitializer는 jar파일을 war로 배포할 경우에 생성해서 상속받는다.
 * 즉, war파일로 배포하지 않을 경우에는 상속받을 필요가 없다.
 */

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PortfoloApplication.class);
    }

}
