package daif5.blog_personal;

import daif5.blog_personal.security.services.UserDetailsServiceImpl;
import daif5.blog_personal.service.*;
import daif5.blog_personal.service.impl.*;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BlogPersonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogPersonalApplication.class, args);
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }
    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
    @Bean
    public CategoryService categoryService() {return new CategoryServiceImpl();
    }
    @Bean
    public CommentService commentService() {return new CommentServiceImpl();
    }
    @Bean
    public PictureService pictureService() {
        return new PictureServiceImpl();
    }

    @Bean
    public RoleService roleService(){
        return new RoleServiceImpl();
    }
    @Configuration
    static
    class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

        private ApplicationContext appContext;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            appContext = applicationContext;
        }


    }
}
