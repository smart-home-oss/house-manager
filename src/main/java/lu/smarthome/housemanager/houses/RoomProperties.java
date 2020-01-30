package lu.smarthome.housemanager.houses;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app.room")
public class RoomProperties {

    private int pageMaxSize = 999;

    public int getPageMaxSize() {
        return pageMaxSize;
    }

    public void setPageMaxSize(int maxSize) {
        this.pageMaxSize = maxSize;
    }
}
