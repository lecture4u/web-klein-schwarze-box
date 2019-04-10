package info.dkuswai.abc.KleinSchwarzeBox.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import info.dkuswai.abc.KleinSchwarzeBox.mapper.BasicMapper;

@RestController
public class ApiController {
    @Resource
    BasicMapper basicMapper;

    @GetMapping(value = "/api")
    public HashMap<String, Object> apiHome() {
        HashMap<String, Object> obj = new HashMap<String, Object>();
        obj.put("success", true);
        obj.put("nema", "lee");
        return obj;
    }
}