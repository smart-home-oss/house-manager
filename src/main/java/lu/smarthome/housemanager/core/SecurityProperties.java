package lu.smarthome.housemanager.core;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("app.security")
public class SecurityProperties {

    private boolean useJwtAuth;

    public boolean isUseJwtAuth() {
        return useJwtAuth;
    }

    public void setUseJwtAuth(boolean useJwtAuth) {
        this.useJwtAuth = useJwtAuth;
    }
}
