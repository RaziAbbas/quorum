package com.jpmc.web3j.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class Contract_sol_Stash extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6040516040806101fe833981016040528080519190602001805160009390935550506001556101bb806100436000396000f30060606040526004361061006c5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166312065fe0811461007157806327d3580114610096578063b69ef8a8146100a9578063b7502bc1146100bc578063ddd20b88146100d7575b600080fd5b341561007c57600080fd5b6100846100f0565b60405190815260200160405180910390f35b34156100a157600080fd5b6100846100f6565b34156100b457600080fd5b6100846100fc565b34156100c757600080fd5b6100d5600435602435610102565b005b34156100e257600080fd5b6100d5600435602435610149565b60015490565b60005481565b60015481565b6001805483900390557f9a7b939a56827d05c5b46561f0151a56d475694ad8ced4ac388c9bb1121322d8828260405191825260208201526040908101905180910390a15050565b60018054830190557f9a7b939a56827d05c5b46561f0151a56d475694ad8ced4ac388c9bb1121322d8828260405191825260208201526040908101905180910390a150505600a165627a7a7230582069c57275708e81795beae4ab53f4bdfcbf93a5b1074d45d3227f26a0110ca46b0029";

    protected Contract_sol_Stash(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Contract_sol_Stash(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<BalanceChangedEventResponse> getBalanceChangedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("BalanceChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<BalanceChangedEventResponse> responses = new ArrayList<BalanceChangedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            BalanceChangedEventResponse typedResponse = new BalanceChangedEventResponse();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.txID = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<BalanceChangedEventResponse> balanceChangedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("BalanceChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, BalanceChangedEventResponse>() {
            @Override
            public BalanceChangedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                BalanceChangedEventResponse typedResponse = new BalanceChangedEventResponse();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.txID = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<BigInteger> getBalance() {
        Function function = new Function("getBalance", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> bankName() {
        Function function = new Function("bankName", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> balance() {
        Function function = new Function("balance", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> debit(BigInteger _dAmt, BigInteger txnId) {
        Function function = new Function(
                "debit", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_dAmt), 
                new org.web3j.abi.datatypes.generated.Uint256(txnId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> credit(BigInteger _crAmt, BigInteger txnId) {
        Function function = new Function(
                "credit", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_crAmt), 
                new org.web3j.abi.datatypes.generated.Uint256(txnId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Contract_sol_Stash> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, byte[] _bankName, BigInteger _balance) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_bankName), 
                new org.web3j.abi.datatypes.generated.Int256(_balance)));
        return deployRemoteCall(Contract_sol_Stash.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Contract_sol_Stash> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, byte[] _bankName, BigInteger _balance) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_bankName), 
                new org.web3j.abi.datatypes.generated.Int256(_balance)));
        return deployRemoteCall(Contract_sol_Stash.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Contract_sol_Stash load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Contract_sol_Stash(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Contract_sol_Stash load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Contract_sol_Stash(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class BalanceChangedEventResponse {
        public BigInteger amount;

        public BigInteger txID;
    }
}
