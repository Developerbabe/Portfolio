package tech.portfolo.portfolo.common.conf.message;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageSourceConfig {

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        String[] basenames = new String[] {
                "classpath:i18n/message",
                "classpath:i18n/error"
        };
        messageSource.setBasenames(basenames);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(60);

        return messageSource;
    }

    @Bean
    public MessageSourceAccessor messageSourceAccessor(){
        return new MessageSourceAccessor(messageSource());
    }
}
