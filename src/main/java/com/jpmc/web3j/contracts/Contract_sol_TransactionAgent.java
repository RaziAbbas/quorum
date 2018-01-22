package com.jpmc.web3j.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class Contract_sol_TransactionAgent extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b60028054600160a060020a033316600160a060020a0319909116179055600160005561043b806100406000396000f3006060604052600436106100745763ffffffff60e060020a6000350416632ae6a3b281146100795780633a4ef544146100a157806350cdb4b1146100b4578063a6f9dae1146100d2578063b721e118146100f1578063be6554dc146100f1578063fb6cb61f1461010a578063ff88b6a61461013c575b600080fd5b341561008457600080fd5b61008f60043561015e565b60405190815260200160405180910390f35b34156100ac57600080fd5b61008f6101d6565b34156100bf57600080fd5b6100d06004356024356044356101dc565b005b34156100dd57600080fd5b6100d0600160a060020a03600435166102d1565b34156100fc57600080fd5b6100d060043560243561031b565b341561011557600080fd5b61012060043561039e565b604051600160a060020a03909116815260200160405180910390f35b341561014757600080fd5b6100d0600435600160a060020a03602435166103b9565b60008181526001602052604080822054600160a060020a03169081906312065fe090849051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b15156101b557600080fd5b6102c65a03f115156101c657600080fd5b5050506040518051949350505050565b60005481565b60008381526001602052604080822054848352818320549254600160a060020a039182169390911691839163b7502bc1918691905160e060020a63ffffffff851602815260048101929092526024820152604401600060405180830381600087803b151561024957600080fd5b6102c65a03f1151561025a57600080fd5b50506000805460018101909155600160a060020a038316915063ddd20b8890859060405160e060020a63ffffffff851602815260048101929092526024820152604401600060405180830381600087803b15156102b657600080fd5b6102c65a03f115156102c757600080fd5b5050505050505050565b60025433600160a060020a039081169116146102ec57600080fd5b6002805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b6000828152600160208190526040808320548354928301909355600160a060020a0390921691829163ddd20b88918591905160e060020a63ffffffff851602815260048101929092526024820152604401600060405180830381600087803b151561038557600080fd5b6102c65a03f1151561039657600080fd5b505050505050565b600160205260009081526040902054600160a060020a031681565b60025433600160a060020a039081169116146103d457600080fd5b600091825260016020526040909120805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039092169190911790555600a165627a7a72305820500528f0814a963254f83adb9821c6110d480b5c5f3287b7b8f735c448998d330029";

    protected Contract_sol_TransactionAgent(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Contract_sol_TransactionAgent(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<BigInteger> getStash(byte[] _bankName) {
        Function function = new Function("getStash", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_bankName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> txNum() {
        Function function = new Function("txNum", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transfer(byte[] _src, byte[] _dest, BigInteger amount) {
        Function function = new Function(
                "transfer", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_src), 
                new org.web3j.abi.datatypes.generated.Bytes32(_dest), 
                new org.web3j.abi.datatypes.generated.Int256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> changeOwner(String newOwner) {
        Function function = new Function(
                "changeOwner", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> pledge(byte[] _bankName, BigInteger amount) {
        Function function = new Function(
                "pledge", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_bankName), 
                new org.web3j.abi.datatypes.generated.Int256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> redeem(byte[] _bankName, BigInteger amount) {
        Function function = new Function(
                "redeem", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_bankName), 
                new org.web3j.abi.datatypes.generated.Int256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> stashRegistry(byte[] param0) {
        Function function = new Function("stashRegistry", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> registerStash(byte[] _bankName, String addr) {
        Function function = new Function(
                "registerStash", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_bankName), 
                new org.web3j.abi.datatypes.Address(addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Contract_sol_TransactionAgent> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Contract_sol_TransactionAgent.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Contract_sol_TransactionAgent> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Contract_sol_TransactionAgent.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Contract_sol_TransactionAgent load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Contract_sol_TransactionAgent(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Contract_sol_TransactionAgent load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Contract_sol_TransactionAgent(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
