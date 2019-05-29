package info.dkuswai.abc.KleinSchwarzeBox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import info.dkuswai.abc.KleinSchwarzeBox.core.security.KeyService;
import info.dkuswai.abc.KleinSchwarzeBox.core.tinyBlackBox.TinyBlock;

// @RunWith(SpringRunner.class)
// @SpringBootTest
public class KleinSchwarzeBoxApplicationTests {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Test
	public void contextLoads() {
		
	}

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	public void printReference() {
		System.out.print("hello");
		assertEquals("hello", outContent.toString());

		System.err.print("hello again");
		assertEquals("hello again", errContent.toString());
	}

	@Test
	public void keyTest() {
		//test for generating asymmetric key cryptography
		//espcially for testing via encoding and decoding using base64 of java.util
		KeyService keyService = new KeyService();
		System.out.println("key test");
		System.out.println(keyService.getPublicKey().getEncoded());
		keyService.storeKey("abcde");
		keyService.loadKey("abcde");
		System.out.println(keyService.getPublicKey().getEncoded().toString());
	}

	@Test
	public void tinyBlockInitTest() {
		//gather all the code lines related to initalize a tinyBlock
		TinyBlock myBlock = new TinyBlock("MD5");
		byte[] buffer = new byte[16];
		Random doRand = new Random();
		ArrayList<String> transactionList = new ArrayList<String>();
		transactionList.add("abc");
		transactionList.add("def");
		transactionList.add("ghi");

		String[] transactions = new String[transactionList.size()];
		transactionList.toArray(transactions);

		//transaction logging test
		System.out.print(transactions[0]);
		assertEquals("abc", outContent.toString());

		myBlock.setMessages(transactions);

		buffer = new byte[3]; //4 stands for merkleCount
		doRand.nextBytes(buffer);
		myBlock.setNonce(buffer);
		myBlock.setPreviousBlockHash(buffer);
		myBlock.buildBlock();

		// byte[][] merkleTree = myBlock.getMerkleTree();
		
		System.out.println(myBlock.toString());
		assertEquals("abcasdf", outContent.toString());
	}

}
