package info.dkuswai.abc.KleinSchwarzeBox.controller;

import java.util.HashMap;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.dkuswai.abc.KleinSchwarzeBox.mapper.BasicMapper;
import info.dkuswai.abc.KleinSchwarzeBox.core.security.*;

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

    @GetMapping(value = "/api/hash/**")
    public HashMap<String, Object> apiHash(@RequestParam HashMap<String, Object> params) {
        
        HashMap<String, Object> obj = new HashMap<String, Object>();
        
        //get request parameter from application
        //and take "data" key to digest
        System.out.println(params);
        String data = params.get("data").toString();
        obj.put("success", true);
        
        //If there is an error when data hashed by function named generatHashfunction(),
        //catch an error using exception. 
        //And change the value of key named "success". 
        try {
            obj.put("data", generatHashfunction(data));
        } catch(Exception exception) {
            obj.put("success", false);
            exception.printStackTrace();
        }

        return obj;
    }

    private String generatHashfunction(String data){
    	Hash hashfun = new Hash("MD5");
    	byte[] hash = hashfun.hashFn(data);
		data= hashfun.bytesToString(hash);
		return data;
    }

}
