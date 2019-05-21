package info.dkuswai.abc.KleinSchwarzeBox.controller;

import java.security.PublicKey;
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
    private KeyService key ;


    @GetMapping(value = "/api")
    public HashMap<String, Object> apiHome() {
        HashMap<String, Object> obj = new HashMap<String, Object>();
        obj.put("success", true);
        obj.put("name", "lee");
        return obj;
    }

    @GetMapping(value = "/api/hash/**")
    public HashMap<String, Object> apiHash(@RequestParam HashMap<String, Object> params) {
        
        HashMap<String, Object> obj = new HashMap<String, Object>();
        
        //get request parameter from application
        //and take "data" key to digest
        System.out.println(params);
        String data = params.get("sdf").toString();
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
            key = new KeyService();
            Hash hashfun = new Hash("MD5");
            //generate public key
            String pubLabel = hashfun.bytesToString(key.getPublicKey().getEncoded());
            StringBuffer pubBuffer = new StringBuffer(pubLabel);
            for(int i =0; i<pubBuffer.length(); i++){
                if(i%130 == 0){
                    pubBuffer.insert(i, "\n");
                }
            }
            pubLabel = pubBuffer.toString();
            
            //generate private key
            String priLabel = hashfun.bytesToString(key.getPrivateKey().getEncoded());
            StringBuffer priBuffer = new StringBuffer(priLabel);
            for(int i =0; i<priBuffer.length(); i++){
                if(i%130== 0){
                    priBuffer.insert(i, "\n");
                }
            }
            priLabel = priBuffer.toString();
            
            //print public key and private key into json type
            obj.put("PublicKey: ", pubLabel);
            obj.put("PrivateKey: ", priLabel);
            
        } catch(Exception exception) {
                obj.put("success", false);
                exception.printStackTrace();
        }
        return obj;
    }

    @GetMapping(value = "/api/puben")
    private HashMap<String, Object> publicEncryption(@RequestParam HashMap<String, Object> params){
        HashMap<String, Object> obj = new HashMap<String, Object>();
        String hashData = params.get("data").toString();
        PublicKey pubkey = (PublicKey)params.get("pubkey");
        key = new KeyService();

        System.out.println(hashData);
        String publicKey = key.encryptTextToPublic(hashData);

        try{
            
            obj.put("publicKey", publicKey);
        } catch(Exception e){
            obj.put("success", false);
            e.printStackTrace();
            //System.out.println("<script>alert('Encryption Error!'); history.go(-1);</script>");
        }
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
