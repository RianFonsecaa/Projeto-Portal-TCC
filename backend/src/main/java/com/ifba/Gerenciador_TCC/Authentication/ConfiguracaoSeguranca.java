import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/login", "/registrar").permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(jwtFiltroAutenticacao(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public JwtFiltroAutenticacao jwtFiltroAutenticacao() {
        return new JwtFiltroAutenticacao();
    }
}
