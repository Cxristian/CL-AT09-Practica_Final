package myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MyAppController.
 * @author Cxristian Lujan.
 */
@Controller
public class MyAppController {

    /**
     * Index.
     * @return A string.
     */
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
}