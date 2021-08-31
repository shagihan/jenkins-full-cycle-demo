package com.example.jenkinsfullcycledemo.Controllers;

import com.example.jenkinsfullcycledemo.service.CalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cal")
public class CalController {

    @Autowired
    private CalService calService;

    @GetMapping(path = "/add/{a}/{b}")
    public int add(@PathVariable int a, @PathVariable int b) {
        return calService.addInt(a, b);
    }

    @GetMapping(path = "/subtract/{a}/{b}")
    public int subtract(@PathVariable int a, @PathVariable int b) {
        return calService.subtractInt(a, b);
    }

    @GetMapping(path = "/multiply/{a}/{b}")
    public int multiply(@PathVariable int a, @PathVariable int b) {
        return calService.multiplyInt(a, b);
    }

    @GetMapping(path = "/divide/{a}/{b}")
    public double divide(@PathVariable int a, @PathVariable int b) {
        return calService.divideInt(a, b);
    }


}
