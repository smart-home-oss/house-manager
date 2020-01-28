package lu.smarthome.housemanager.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@CrossOrigin("${app.api.cors}")
public class TechnicalController {

    @Value("${app.api.version.default}")
    private String defaultApiSpecUri;

    @GetMapping("/api")
    public RedirectView redirectWithUsingRedirectView() {
        return new RedirectView("/webjars/swagger-ui/index.html?url=" + defaultApiSpecUri + ".yml");
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    @ResponseStatus(HttpStatus.OK)
    public void options() {
        //this option method is used by browser
    }

}
