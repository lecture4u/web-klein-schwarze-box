package info.dkuswai.abc.KleinSchwarzeBox.controller;

import java.awt.Label;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    /*There is a bug on decryption function.
    I wrote about bug on BlockChaeEun issue#5, and this is related with bug1.
    It just need to change privateKey to publicKey on decryptTextToPublic in KeyService.java, 
    and publicKey to privateKey on privateDecryption on decryptTextToPrivate. */
    /* Public & Private Key part - public key decryption 
        2019.05.22 */
    @GetMapping(value = "/api/pubde")
    public HashMap<String, Object> publicDecryption(@RequestParam HashMap<String, Object> params){
        
        HashMap<String, Object> obj = new HashMap<String, Object>();
        String publicKey = params.get("data").toString();
        String decryptPublic = key.decryptTextToPublic(publicKey);

        try{
            obj.put("decryptPublic", decryptPublic);
            obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
        }
        return obj;
    }

    /* Public & Private Key part - private key encryption */
    @GetMapping(value = "/api/prien")
    private HashMap<String, Object> privateEncryption(@RequestParam HashMap<String, Object> params){
        HashMap<String, Object> obj = new HashMap<String, Object>();
        String dataToPrivate = params.get("data").toString();
        //PrivateKey prikey = (PrivateKey)params.get("prikey");
        // key = new KeyService();
        System.out.println(dataToPrivate);
        String encryptPrivate = key.encryptTextToPrivate(dataToPrivate);

        try{
            obj.put("encryptPrivate", encryptPrivate);
            obj.put("success", true);
        } catch(Exception e){
            obj.put("success", false);
            e.printStackTrace();
            //System.out.println("<script>alert('Encryption Error!'); history.go(-1);</script>");
        }
        return obj;
    }
    
    /* Public & Private Key part - private key decryption 
        2019.05.22*/
    @GetMapping(value = "/api/pride")
    public HashMap<String, Object> privateDecryption(@RequestParam HashMap<String, Object> params){
        
        HashMap<String, Object> obj = new HashMap<String, Object>();
        String hashData = params.get("data").toString();
        String decryptPrivate = key.decryptTextToPrivate(hashData);

        try{
            obj.put("decryptPrivate", decryptPrivate);
            obj.put("success", true);
		}catch(Exception e){
			obj.put("success", false);
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
    
    /*wallet - addTransaction() and rockToChain()*/
    public void addTransactionToTransaction(){
        //addTransaction(transactionPane,"transaction");
    }
    
    // @GetMapping(value = "/api/maketree")
    // public HashMap<String, Object> makeMerkleTree(@RequestParam HashMap<String, Object> params) {
    //     mekleNodeList = new ArrayList<MerkleNode>();
    //     System.out.println("Start Making block");
    //}

    // private void addTransaction(AnchorPane tranPane, String paneName){
		
	// 	if(paneName.equals("transaction")){
	// 		TransactionNode tn = new TransactionNode("Transaction"+transactionNumber,transactionXpoint,transactionYpoint);
	// 		tn.addToPane(tranPane);
	// 		transactionFieldList.add(tn.getNode());
			
	// 		if(transactionXpoint>200){
	// 			transactionYpoint +=61;
	// 			transactionXpoint =14;
	// 		}
	// 		else{
	// 		    transactionXpoint +=200;
			    
	// 		}
	// 		transactionNumber++;
	// 		tn.getNode().requestFocus();
	// 	}
	// 	else if(paneName.equals("wallet1")){
	// 		TransactionNode tn = new TransactionNode("Transaction"+walletNumber,wallet1Xpoint,wallet1Ypoint);
	// 		tn.addToPane(tranPane);
	// 		//wallet1FieldList.add(tn.getNode());
	// 		allWalletFieldList.add(tn.getNode());
	// 		allWalletFieldWallet.add("wallet1");
	// 		if(wallet1Xpoint>400){
	// 			wallet1Ypoint +=61;
	// 			wallet1Xpoint =14;
	// 		}
	// 		else{
	// 			wallet1Xpoint +=200;
			    
	// 		}
	// 		walletNumber++;
	// 		tn.getNode().requestFocus();
	// 	}
	// 	else if(paneName.equals("wallet2")){
	// 		TransactionNode tn = new TransactionNode("Transaction"+walletNumber,wallet2Xpoint,wallet2Ypoint);
	// 		tn.addToPane(tranPane);
	// 		//wallet2FieldList.add(tn.getNode());
	// 		allWalletFieldList.add(tn.getNode());
	// 		allWalletFieldWallet.add("wallet2");
	// 		if(wallet2Xpoint>400){
	// 			wallet2Ypoint +=61;
	// 			wallet2Xpoint =14;
	// 		}
	// 		else{
	// 			wallet2Xpoint +=200;
			    
	// 		}
	// 		walletNumber++;
	// 		tn.getNode().requestFocus();
	// 	}
	// 	else if(paneName.equals("wallet3")){
	// 		TransactionNode tn = new TransactionNode("Transaction"+walletNumber,wallet3Xpoint,wallet3Ypoint);
	// 		tn.addToPane(tranPane);
	// 		//wallet3FieldList.add(tn.getNode());
	// 		allWalletFieldList.add(tn.getNode());
	// 		allWalletFieldWallet.add("wallet3");
	// 		if(wallet3Xpoint>400){
	// 			wallet3Ypoint +=61;
	// 			wallet3Xpoint =14;
	// 		}
	// 		else{
	// 			wallet3Xpoint +=200;
			    
	// 		}
	// 		walletNumber++;
	// 		tn.getNode().requestFocus();
	// 	}	
    // }
}
