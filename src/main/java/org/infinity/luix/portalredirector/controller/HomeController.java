package org.infinity.luix.portalredirector.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class HomeController {

    private String portalUrl = "http://pm6422.club:6040";

    @PostMapping("/api/portal-url")
    public void setPortalUrl(@RequestParam(value = "url") String url) {
        this.portalUrl = url;
    }

    @GetMapping("/api/portal-url")
    public String getPortalUrl() {
        return this.portalUrl;
    }

    /**
     * Home page.
     */
    @GetMapping("/")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect(portalUrl);
    }
}
