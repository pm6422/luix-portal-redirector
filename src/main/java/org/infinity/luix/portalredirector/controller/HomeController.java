package org.infinity.luix.portalredirector.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class HomeController {

    /**
     * Home page.
     */
    @GetMapping("/")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://pm6422.club:6040");
    }
}
