package info.dkuswai.abc.KleinSchwarzeBox.controller;

import java.security.PrivateKey;
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
    KeyService key;

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
            String pubLabel = hashfun.bytesToString(key.getPublicKey().getEncoded());
            StringBuffer pubBuffer = new StringBuffer(pubLabel);
            for(int i =0; i<pubBuffer.length(); i++){
                if(i%130 == 0){
                    pubBuffer.insert(i, "\n");
                }
            }
            pubLabel = pubBuffer.toString();
            
            String priLabel = hashfun.bytesToString(key.getPrivateKey().getEncoded());
            StringBuffer priBuffer = new StringBuffer(priLabel);
            for(int i =0; i<priBuffer.length(); i++){
                if(i%130== 0){
                    priBuffer.insert(i, "\n");
                }
            }
            priLabel = priBuffer.toString();
            
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

    /*There is a bug on decryption function.
    I wrote about bug on BlockChaeEun issue#5, and this is related with bug1.
    It just need to change privateKey to publicKey on publicDecryption, 
    and publicKey to privateKey on privateDecryption. */
    @GetMapping(value = "/api/pubde")
    private HashMap<String, Object> publicDecryption(@RequestParam HashMap<String, Object> params){
        HashMap<String, Object> obj = new HashMap<String, Object>();

        return obj;
    }

    @GetMapping(value = "/api/prien")
    private HashMap<String, Object> privateEncryption(@RequestParam HashMap<String, Object> params){
        HashMap<String, Object> obj = new HashMap<String, Object>();
        String dataToPrivate = params.get("data").toString();
        PrivateKey prikey = (PrivateKey)params.get("prikey");
        key = new KeyService();
        System.out.println(dataToPrivate);
        String privateKey = key.encryptTextToPrivate(dataToPrivate);

        try{
            obj.put("prikey", privateKey);
        } catch(Exception e){
            obj.put("success", false);
            e.printStackTrace();
            //System.out.println("<script>alert('Encryption Error!'); history.go(-1);</script>");
        }
        return obj;
    }
   
    @GetMapping(value = "/api/pride")
    private HashMap<String, Object> privateDecryption(@RequestAttribute(value = "prikey") HashMap<String, Object> params){
        HashMap<String, Object> obj = new HashMap<String, Object>();
        String dataFromPrivate = params.get("prikey").toString();
        // PrivateKey prikey = (PrivateKey)params.get("prikey");
        // key = new KeyService();
        System.out.println(dataFromPrivate);
        String privateKey = key.decryptTextToPrivate(dataFromPrivate);

        try{
            obj.put("prikey", privateKey);
        } catch(Exception e){
            obj.put("success", false);
            e.printStackTrace();
            //System.out.println("<script>alert('Encryption Error!'); history.go(-1);</script>");
        }
        return obj;
    }
    
    /* hash + hash hashing part 
        2019.05.21 */
    @GetMapping(value = "/api/hashplus")
    public HashMap<String, Object> hashPlusHashGenerate(@RequestParam HashMap<String, Object> params1, @RequestParam HashMap<String, Object> params2) {
        
        HashMap<String, Object> obj = new HashMap<String, Object>();
        
        //get request parameter from application
        //and take "data1" and "data2" key to digest
        System.out.println(params1 + " , " + params2);
        String data = params1.get("data1").toString() + params2.get("data2");
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

    /* security check and using key part on Box
       deAndHashing and signatureDe function
       2019.05.22*/
    @GetMapping(value = "/api/datahash")
    public HashMap<String, Object> deAndHashing(@RequestParam HashMap<String, Object> params) {
        
        HashMap<String, Object> obj = new HashMap<String, Object>();
        String privatePassword = params.get("data").toString();
		Hash hashfun = new Hash("MD5");
        byte[] hash = hashfun.hashFn(privatePassword);
        String hashString = hashfun.bytesToString(hash);
        
        try{
            obj.put("privatePassword : " , privatePassword);
            obj.put("hashString : ", hashString);
            obj.put("success", true);
        }catch(Exception e){
            obj.put("success", false);
        }
        return obj;
	}

    @GetMapping(value = "/api/signde")
    public HashMap<String, Object> signatureDe(@RequestParam HashMap<String, Object> params) {		
        
        HashMap<String, Object> obj = new HashMap<String, Object>();
        String signature = params.get("data").toString();
        String deHash = key.decryptTextToPublic(signature);

        try{
            obj.put("deHash", deHash);
            obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
        }
        return obj;
    }
    
    /*wallet - addTransaction() and rockToChain()*/
    public void addTransactionToTransaction(){
        //addTransaction(transactionPane,"transaction");
    }

    
}
