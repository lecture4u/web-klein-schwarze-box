package info.dkuswai.abc.KleinSchwarzeBox.controller;

import java.util.HashMap;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Base64;

import info.dkuswai.abc.KleinSchwarzeBox.mapper.BasicMapper;
import info.dkuswai.abc.KleinSchwarzeBox.core.security.*;

@RestController
public class ApiController {
    @Resource
    BasicMapper basicMapper;
    private KeyService key ;


    @GetMapping(value = "/api")
    public HashMap<String, Object> apiHome() {
        HashMap<String, Object> obj = new HashMap<String, Object>();
        obj.put("success", true);
        obj.put("name", "lee");
        return obj;
    }

    @GetMapping(value = "/api/hash")
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

    /*Assymetric Cryptography from here*/
    @GetMapping(value = "/api/genkey")
    public HashMap<String, Object> apiGenerateKey(){
        HashMap<String, Object> obj = new HashMap<String, Object>();
        //If there is an error ,
        //catch an error using exception. 
        //And change the value of key named "success". 
        try {
            obj.put("success", true);
            //at this moment, instantiating a KeyService object, there a key pair is generated
            key = new KeyService();         
            //encoding with Base64 in String for preventing error during the converting   
            obj.put("pubkey", Base64.getEncoder().encodeToString(key.getPublicKey().getEncoded()));
            obj.put("prikey", Base64.getEncoder().encodeToString(key.getPrivateKey().getEncoded()));
        } catch(Exception exception) {
                obj.put("success", false);
                exception.printStackTrace();
        }
        return obj;
    }

    @PostMapping(value = "/api/puben")
    private HashMap<String, Object> publicEncryption(@RequestBody HashMap<String, String> params){

        //return object
        HashMap<String, Object> obj = new HashMap<String, Object>();

        //data from outside
        String plainText = params.get("data").toString();
        String pubKeyParams = params.get("pubKey");
        String priKeyParams = params.get("priKey");
        
        //instantiate a KeyService class with private/public key from outside in a String format
        key = new KeyService(pubKeyParams, priKeyParams);

        //encryp plainText into cipher text using public key encryption
        String cipherText = key.encryptTextToPublic(plainText);
        try{
            obj.put("success", true);
            obj.put("cipherText", cipherText);
        } catch(Exception e){
            obj.put("success", false);
            e.printStackTrace();
        }
        System.out.println(obj);
        return obj;
    }

//     @RequestMapping(value = "/api/pd")
//     private HashMap<String, Object> publicDecryption(@RequestBody HashMap<String, Object> param){
//         HashMap<String, Object> obj = new HashMap<String, Object>();
//         try{
//             String privateKey = (String) param.get("publicKey");
//             obj.put("hashData", key.decryptTextToPublic(privateKey));
//             obj.put("success", true);
//         }
//         catch(Exception e){
//             obj.put("success", false);
//             e.printStackTrace();
//             System.out.println("<script>alert('Decryption Error!'); history.go(-1);</script>");
//         }
//         return obj;
//     }
    /*private void encryptAlert(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Encryption Error!");
        alert.setHeaderText(null);
        alert.setContentText("Generate key first!");

        alert.showAndWait();
    }*/



}
