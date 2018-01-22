package com.jpmc.ilp.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class Std_sol_named extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b60405160208061025e83398101604052808051915061003b90506401000000006100a26100b382021704565b600160a060020a031663e1fa8e84826040517c010000000000000000000000000000000000000000000000000000000063ffffffff84160281526004810191909152602401600060405180830381600087803b151561009957600080fd5b6102c65a03f115156100aa57600080fd5b505050506100cb565b73084f6a99003dae6d3906664fdbf43dd09930d0e390565b610184806100da6000396000f30060606040526004361061004b5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663060057548114610050578063a550f86d1461008c575b600080fd5b341561005b57600080fd5b6100636100a2565b60405173ffffffffffffffffffffffffffffffffffffffff909116815260200160405180910390f35b341561009757600080fd5b6100636004356100ba565b73084f6a99003dae6d3906664fdbf43dd09930d0e390565b60006100c46100a2565b73ffffffffffffffffffffffffffffffffffffffff1663bb34534c836000604051602001526040517c010000000000000000000000000000000000000000000000000000000063ffffffff84160281526004810191909152602401602060405180830381600087803b151561013857600080fd5b6102c65a03f1151561014957600080fd5b505050604051805193925050505600a165627a7a7230582074fd97add2c392d4429efa1eb3a91ff10795535638fbe9534b649a4ed8e4f8940029";

    protected Std_sol_named(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Std_sol_named(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> nameRegAddress() {
        Function function = new Function(
                "nameRegAddress", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> named(byte[] name) {
        Function function = new Function(
                "named", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Std_sol_named> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, byte[] name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(name)));
        return deployRemoteCall(Std_sol_named.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Std_sol_named> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, byte[] name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(name)));
        return deployRemoteCall(Std_sol_named.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Std_sol_named load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Std_sol_named(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Std_sol_named load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Std_sol_named(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
