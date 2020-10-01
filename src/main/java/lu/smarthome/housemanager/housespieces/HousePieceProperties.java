package lu.smarthome.housemanager.housespieces;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app.house-piece")
public class HousePieceProperties {

    private int pageMaxSize = 999;

    public int getPageMaxSize() {
        return pageMaxSize;
    }

    public void setPageMaxSize(int maxSize) {
        this.pageMaxSize = maxSize;
    }
}
