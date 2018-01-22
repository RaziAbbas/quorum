package org.web3j.quorum;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;
import static org.web3j.tx.Contract.GAS_LIMIT;
import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.quorum.generated.Greeter;
import org.web3j.quorum.generated.HumanStandardToken;
import org.web3j.quorum.methods.response.QuorumNodeInfo;
import org.web3j.quorum.tx.ClientTransactionManager;
import org.web3j.utils.Numeric;

import com.jpmc.ilp.contracts.Stash_sol_Stash;
import com.jpmc.ilp.contracts.Std_sol_NameReg;
import com.jpmc.ilp.contracts.Std_sol_mortal;
import com.jpmc.ilp.contracts.Std_sol_nameRegAware;
import com.jpmc.ilp.contracts.Std_sol_named;
import com.jpmc.ilp.contracts.Std_sol_owned;
import com.jpmc.ilp.contracts.TransactionAgent_sol_TransactionAgent;

/**
 * Useful integration tests for verifying Quorum deployments and transaction
 * privacy.
 */
public class QuorumIT {

	private static List<Node> nodes = null;
	private String[] pubKeys = { "BULeR8JyUWhiuuCMU/HLA0Q5pzkYT+cHII3ZKBey3Bo=",
			"QfeDAys9MPDs2XHExtc84jKGHxZg/aj52DTh0vtA3Xc=", "1iTZde/ndBHvzhcl7V68x44Vx7pl8nwx9LqnM/AfJUg=",
			"oNspPPgszVUFw0qmGFfWwh1uxVUXgvBxleXORHj07g8=", "R56gy4dn24YOjwyesTczYa8m5xhP6hF2uTMCju/1xkY=",
			"UfNSeSGySeKg11DVNEnqrUtxYRVor4+CvluI8tVv62Y=", "ROAZBWtSacxXQrOe3FGAqJDyJjFePR5ce4TSIzmJ0Bc=" };
	private String[] nodesPort = { "22001", "22002", "22003", "22004", "22005", "22006", "22007" };
	private String[] address = { "0xed9d02e382b34818e88b88a309c7fe71e65f419d",
			"0xca843569e3427144cead5e4d5999a3d0ccf92b8e", "0x0fbdc686b912d7722dc86510934589e0aaf3b55a",
			"0x9186eb3d20cbd1f5f992a950d808c4495153abd5", "0x0638e1574728b6d862dd5d3a3e0942c3be47d996",
			"0x18c1becf82804ed869fd9540374db5b18ac293a6", "0x701ed11e8d629dcf53173ea2f1d2a9a031d0d663" };

	@Before
	public void setNodes() {
		nodes = new ArrayList<Node>();

		Node node = null;
		for (int i = 0; i < 6; i++) {
			node = new Node(address[i], Arrays.asList(pubKeys[0] /* pubKeys[i] , pubKeys[4], pubKeys[5], pubKeys[6] */),
					"http://127.0.0.1:" + nodesPort[i]);
			nodes.add(node);
		}
	}

	@Test
	public void testDeployILPContract() throws Exception {
		// std sol, stash sol, transaction sol
		//Transaction - InitIlpTransfer function and event
		deploySTDSolMortal(nodes.get(0), nodes.get(1), Arrays.asList(pubKeys[0], pubKeys[2]), Integer.toString(777777));
		deployStashSolStash(nodes.get(0), nodes.get(1), Arrays.asList(pubKeys[0], pubKeys[2]), Integer.toString(777777));
		deployTransactionAgent(nodes.get(0), nodes.get(1), Arrays.asList(pubKeys[0], pubKeys[2]), Integer.toString(777777));

		System.out.println("------------testDeployILPContract Done --------------");
	}

	private void deployTransactionAgent(Node sourceNode, Node destNode, List<String> privateForKeys, String requestId)
			throws Exception {

		Quorum quorum = Quorum.build(new HttpService(sourceNode.getUrl()));
		// Deploy
		ClientTransactionManager transactionManager = new ClientTransactionManager(quorum, destNode.getAddress(), privateForKeys, 50, 10000);

		TransactionAgent_sol_TransactionAgent contract = TransactionAgent_sol_TransactionAgent.deploy(quorum, transactionManager, GAS_PRICE, GAS_LIMIT).send();
		System.out.println("TransactionAgent_sol_TransactionAgent - Address -- " + contract.getContractAddress());
	}

	private void deploySTDSolMortal(Node sourceNode, Node destNode, List<String> privateForKeys, String requestId)
			throws Exception {

		Quorum quorum = Quorum.build(new HttpService(sourceNode.getUrl()));
		// Deploy
		ClientTransactionManager transactionManager = new ClientTransactionManager(quorum, destNode.getAddress(), privateForKeys, 50, 10000);

		Std_sol_mortal stdMortalContract = Std_sol_mortal.deploy(quorum, transactionManager, GAS_PRICE, GAS_LIMIT).send();
		Std_sol_named stdNamedContract = Std_sol_named.deploy(quorum, transactionManager, GAS_PRICE, GAS_LIMIT, getByte32Array("Named")).send();
		Std_sol_NameReg stdNamedReg = Std_sol_NameReg.deploy(quorum, transactionManager, GAS_PRICE, GAS_LIMIT).send();
		Std_sol_nameRegAware stdNameRegAware = Std_sol_nameRegAware.deploy(quorum, transactionManager, GAS_PRICE, GAS_LIMIT).send();
		Std_sol_owned stdOwned = Std_sol_owned.deploy(quorum, transactionManager, GAS_PRICE, GAS_LIMIT).send();

		System.out.println("Std_sol_mortal - Address -- " + stdMortalContract.getContractAddress());
		System.out.println("Std_sol_named - Address -- " + stdNamedContract.getContractAddress());
		System.out.println("Std_sol_NameReg - Address -- " + stdNamedReg.getContractAddress());
		System.out.println("Std_sol_nameRegAware - Address -- " + stdNameRegAware.getContractAddress());
		System.out.println("Std_sol_owned - Address -- " + stdOwned.getContractAddress());
	}

	private void deployStashSolStash(Node sourceNode, Node destNode, List<String> privateForKeys, String requestId)
			throws Exception {

		Quorum quorum = Quorum.build(new HttpService(sourceNode.getUrl()));
		// Deploy
		ClientTransactionManager transactionManager = new ClientTransactionManager(quorum, destNode.getAddress(), privateForKeys, 50, 10000);

		Stash_sol_Stash contract = Stash_sol_Stash.deploy(quorum, transactionManager, GAS_PRICE, GAS_LIMIT, "JPM", nodes.get(0).getAddress(), new BigInteger("30000"), "reg").send();
		System.out.println("Stash_sol_Stash - Address -- " + contract.getContractAddress());
	}

	@Test
	public void testGreeterNode() throws Exception {
		runPrivateGreeterTest(nodes.get(0), nodes.get(1),
				Arrays.asList(pubKeys[0], pubKeys[2]/* , pubKeys[4], pubKeys[5], pubKeys[6] */),
				Integer.toString(777777));
	}

	private void runPrivateGreeterTest(Node sourceNode, Node destNode, List<String> privateForKeys, String requestId)
			throws Exception {

		Quorum quorum = Quorum.build(new HttpService(sourceNode.getUrl()));

		// Print Basics - 1
		Web3ClientVersion clientVersion = quorum.web3ClientVersion().send();
		System.out.println("Client Version -- " + clientVersion.getWeb3ClientVersion());

		// Print Basics - 1
		QuorumNodeInfo nodeInfo = quorum.quorumNodeInfo().sendAsync().get();
		System.out.println("Vote Account = " + nodeInfo.getNodeInfo().getVoteAccount());
		System.out.println("RPC -- " + quorum.ethAccounts().getJsonrpc());

		// Deploy
		ClientTransactionManager transactionManager = new ClientTransactionManager(quorum, destNode.getAddress(),
				privateForKeys, 50, 10000);

		List<String> prFor = transactionManager.getPrivateFor();
		System.out.println("Transaction Prive For --" + prFor);
		String greeting = "Hello Quorum world! [" + requestId + "]";
		Greeter contract = null;
		try {
			contract = Greeter.deploy(quorum, transactionManager, GAS_PRICE, GAS_LIMIT, greeting).send();
			assertTrue("Output expected - " + greeting, greeting.equals(contract.greet().send()));
			System.out.println("Address -- " + contract.getContractAddress());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		// contract.greet().send();

		// assertThat(contract.greet().send(), is(greeting));
	}

	private void runPrivateHumanStandardTokenTest(Node sourceNode, Node destNode) throws Exception {

		Quorum quorum = Quorum.build(new HttpService(sourceNode.getUrl()));

		ClientTransactionManager transactionManager = new ClientTransactionManager(quorum, sourceNode.getAddress(),
				destNode.getPublicKeys());

		BigInteger aliceQty = BigInteger.valueOf(1_000_000);
		final String aliceAddress = sourceNode.getAddress();
		final String bobAddress = destNode.getAddress();

		HumanStandardToken contract = HumanStandardToken.deploy(quorum, transactionManager, GAS_PRICE, GAS_LIMIT,
				aliceQty, "web3j tokens", BigInteger.valueOf(18), "w3j$").send();

		assertTrue(contract.isValid());

		Assert.assertThat(contract.totalSupply().send(), equalTo(aliceQty));

		Assert.assertThat(contract.balanceOf(sourceNode.getAddress()).send(), equalTo(aliceQty));

		// transfer tokens
		BigInteger transferQuantity = BigInteger.valueOf(100_000);

		TransactionReceipt aliceTransferReceipt = contract.transfer(destNode.getAddress(), transferQuantity).send();

		HumanStandardToken.TransferEventResponse aliceTransferEventValues = contract
				.getTransferEvents(aliceTransferReceipt).get(0);

		Assert.assertThat(aliceTransferEventValues._from, equalTo(aliceAddress));
		Assert.assertThat(aliceTransferEventValues._to, equalTo(bobAddress));
		Assert.assertThat(aliceTransferEventValues._value, equalTo(transferQuantity));

		aliceQty = aliceQty.subtract(transferQuantity);

		BigInteger bobQty = BigInteger.ZERO;
		bobQty = bobQty.add(transferQuantity);

		Assert.assertThat(contract.balanceOf(sourceNode.getAddress()).send(), equalTo(aliceQty));
		Assert.assertThat(contract.balanceOf(destNode.getAddress()).send(), equalTo(bobQty));

		// set an allowance
		Assert.assertThat(contract.allowance(aliceAddress, bobAddress).send(), equalTo(BigInteger.ZERO));

		transferQuantity = BigInteger.valueOf(50);
		TransactionReceipt approveReceipt = contract.approve(destNode.getAddress(), transferQuantity).send();

		HumanStandardToken.ApprovalEventResponse approvalEventValues = contract.getApprovalEvents(approveReceipt)
				.get(0);

		Assert.assertThat(approvalEventValues._owner, equalTo(aliceAddress));
		Assert.assertThat(approvalEventValues._spender, equalTo(bobAddress));
		Assert.assertThat(approvalEventValues._value, equalTo(transferQuantity));

		Assert.assertThat(contract.allowance(aliceAddress, bobAddress).send(), equalTo(transferQuantity));
	}

	private byte[] getByte32Array(String str) {
		char[] chars = str.toCharArray();
		StringBuffer hex = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			hex.append(Integer.toHexString((int) chars[i]));
		}

		String hexStr = hex.toString() + "".join("", Collections.nCopies(32 - (hex.length() / 2), "00"));
		return Numeric.hexStringToByteArray(hexStr);
	}

}
