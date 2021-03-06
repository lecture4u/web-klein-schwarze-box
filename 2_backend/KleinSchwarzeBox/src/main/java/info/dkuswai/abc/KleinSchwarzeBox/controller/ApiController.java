package info.dkuswai.abc.KleinSchwarzeBox.controller;

import java.util.HashMap;
import java.util.Random;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Base64;

import info.dkuswai.abc.KleinSchwarzeBox.mapper.BasicMapper;
import info.dkuswai.abc.KleinSchwarzeBox.core.security.*;
import info.dkuswai.abc.KleinSchwarzeBox.core.tinyBlackBox.TinyBlock;

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

    /* Using on generate hash part */
    private String generatHashfunction(String data){
    	Hash hashfun = new Hash("MD5");
    	byte[] hash = hashfun.hashFn(data);
		data= hashfun.bytesToString(hash);
		return data;
    }

    /* Public & Private Key part - generate key */
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

    /* Public & Private Key part - public key encryption */
    @PostMapping(value = "/api/puben")
    private HashMap<String, Object> publicEncryption(@RequestBody HashMap<String, String> params){

        //return object
        HashMap<String, Object> obj = new HashMap<String, Object>();

        //data from outside
        String plainText = params.get("data");
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

    /* Public & Private Key part - public key decryption 
        2019.05.22 */
    @PostMapping(value = "/api/pubde")
    public HashMap<String, Object> publicDecryption(@RequestBody HashMap<String, String> params){
        
        //return object
        HashMap<String, Object> obj = new HashMap<String, Object>();

        //data from outside
        String cipherText = params.get("data");
        String pubKeyParams = params.get("pubKey");
        String priKeyParams = params.get("priKey");
        
        //instantiate a KeyService class with private/public key from outside in a String format
        key = new KeyService(pubKeyParams, priKeyParams);

        System.out.println("params::" + params);
        //decrypt cipherText into decrypted text using private key decryption
        String decrypted = key.decryptTextToPublic(cipherText);
        try{
            obj.put("success", true);
            obj.put("decrypted", decrypted);
        } catch(Exception e){
            obj.put("success", false);
            e.printStackTrace();
        }
        System.out.println(obj);
        return obj;
    }

    /* Public & Private Key part - private key encryption */
    @PostMapping(value = "/api/prien")
    private HashMap<String, Object> privateEncryption(@RequestBody HashMap<String, String> params){

        //return object
        HashMap<String, Object> obj = new HashMap<String, Object>();

        //data from outside
        String plainText = params.get("data");
        String pubKeyParams = params.get("pubKey");
        String priKeyParams = params.get("priKey");
        
        //instantiate a KeyService class with private/public key from outside in a String format
        key = new KeyService(pubKeyParams, priKeyParams);

        //encryp plainText into cipher text using public key encryption
        String cipherText = key.encryptTextToPrivate(plainText);
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
    
    /* Public & Private Key part - private key decryption 
        2019.05.22*/
    @PostMapping(value = "/api/pride")
    public HashMap<String, Object> privateDecryption(@RequestBody HashMap<String, String> params){
    
        //return object
        HashMap<String, Object> obj = new HashMap<String, Object>();

        //data from outside
        String cipherText = params.get("data").toString();
        String pubKeyParams = params.get("pubKey");
        String priKeyParams = params.get("priKey");
        
        //instantiate a KeyService class with private/public key from outside in a String format
        key = new KeyService(pubKeyParams, priKeyParams);

        System.out.println("params::" + params);
        //decrypt cipherText into decrypted text using private key decryption
        String decrypted = key.decryptTextToPrivate(cipherText);
        try{
            obj.put("success", true);
            obj.put("decrypted", decrypted);
        } catch(Exception e){
            obj.put("success", false);
            e.printStackTrace();
        }
        System.out.println(obj);
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

    /* security - security check and using key part 
       deAndHashing function
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
    /* security - security check and using key part 
       decrypt a encrypted signature private key 
       2019.05.22 */
    @GetMapping(value = "/api/signde")
    public HashMap<String, Object> signatureDe(@RequestParam HashMap<String, Object> params) {		
        
        HashMap<String, Object> obj = new HashMap<String, Object>();
        String signature = params.get("data").toString();
        String deHash = key.decryptTextToPrivate(signature);

        try{
            obj.put("deHash", deHash);
            obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
        }
        return obj;
    }
    
    @PostMapping(value = "/api/transaction")
    public HashMap<String, Object> transaction(@RequestBody HashMap<String, Object> params) {

        HashMap<String, Object> obj = new HashMap<String, Object>();
        Random doRand = new Random();
        TinyBlock myBlock = new TinyBlock("MD5");

        //need to instantiate a complete tinyBlock
        //1. transaction list <- params
        //2. a number of transaction list

        //params data example below 
        //{data=[{title=1, description=, hashed=c4ca4238a0b923820dcc509a6f75849b}, 
        //{title=3, description=, hashed=eccbc87e4b5ce2fe28308fd9f2a7baf3}, 
        //{title=2, description=, hashed=c81e728d9d4c2f636f067f89cc14862c}]}
        ArrayList<HashMap<String, String>> transactionList = (ArrayList<HashMap<String, String>>)params.get("data");
        
        int transactionSize = transactionList.size();
        String[] transactions = new String[transactionSize];
        //import into transactions from messageList
        for(int i = 0; i < transactionSize; i++) {
            transactions[i] = transactionList.get(i).get("title");
        }
                
        myBlock.setMessages(transactions);

        //I don't why yet but guess what related to binary tree structure
        int merkleCount = 2;
        while(merkleCount < transactionList.size()) {
            merkleCount *= 2;
        }

        byte[] buffer = new byte[merkleCount];
        doRand.nextBytes(buffer);

        //setting up a block
        myBlock.setNonce(buffer);
        myBlock.setPreviousBlockHash(myBlock.hashFn(buffer));
        myBlock.buildBlock();
        System.out.println(myBlock);

        byte[][] blockHead = myBlock.getHead();
        obj.put("success", true);
        obj.put("nonce", myBlock.bytesToString(blockHead[0]));
        obj.put("previousBlockHash", myBlock.bytesToString(blockHead[1]));
        obj.put("merkleTreeRoot", myBlock.bytesToString(blockHead[2]));
        //tree structure also have to be sent later
        
        return obj;
    }
}
