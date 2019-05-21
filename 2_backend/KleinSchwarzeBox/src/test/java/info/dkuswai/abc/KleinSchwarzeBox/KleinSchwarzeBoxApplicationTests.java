package info.dkuswai.abc.KleinSchwarzeBox;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import info.dkuswai.abc.KleinSchwarzeBox.core.security.KeyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KleinSchwarzeBoxApplicationTests {

	@Test
	public void contextLoads() {
		KeyService keyService = new KeyService();
		System.out.println("key test");
		System.out.println(keyService.getPublicKey().getEncoded());
		keyService.storeKey("abcde");
		keyService.loadKey("abcde");
		System.out.println(keyService.getPublicKey().getEncoded().toString());
	}

}
