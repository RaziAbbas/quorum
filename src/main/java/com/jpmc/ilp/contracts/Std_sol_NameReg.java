package com.jpmc.ilp.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
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
public class Std_sol_NameReg extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6101508061001e6000396000f30060606040526004361061006c5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166341c0e1b58114610071578063bb34534c14610086578063e1fa8e84146100c5578063e79a198f14610071578063f5c57382146100db575b600080fd5b341561007c57600080fd5b610084610119565b005b341561009157600080fd5b61009c60043561011b565b60405173ffffffffffffffffffffffffffffffffffffffff909116815260200160405180910390f35b34156100d057600080fd5b610084600435610121565b34156100e657600080fd5b61010773ffffffffffffffffffffffffffffffffffffffff6004351661011b565b60405190815260200160405180910390f35b565b50600090565b505600a165627a7a72305820d2cf37e80635511b8f2bf84908a987763716488515d386ab31f4aea3bce3d4ad0029";

    protected Std_sol_NameReg(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Std_sol_NameReg(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> kill() {
        Function function = new Function(
                "kill", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> addressOf(byte[] name) {
        Function function = new Function("addressOf", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(name)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> register(byte[] name) {
        Function function = new Function(
                "register", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> unregister() {
        Function function = new Function(
                "unregister", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<byte[]> nameOf(String addr) {
        Function function = new Function("nameOf", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public static RemoteCall<Std_sol_NameReg> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Std_sol_NameReg.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Std_sol_NameReg> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Std_sol_NameReg.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Std_sol_NameReg load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Std_sol_NameReg(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Std_sol_NameReg load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Std_sol_NameReg(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
