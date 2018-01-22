package com.jpmc.ilp.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
public class Stash_sol_Stash extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b60405161098838038061098883398101604052808051820191906020018051919060200180519190602001805160008054600160a060020a03191633600160a060020a03161790559190910190507f537461736800000000000000000000000000000000000000000000000000000061009364010000000061015881026103f01704565b600160a060020a031663e1fa8e84826040517c010000000000000000000000000000000000000000000000000000000063ffffffff84160281526004810191909152602401600060405180830381600087803b15156100f157600080fd5b6102c65a03f1151561010257600080fd5b5050505083600190805161011a929160200190610171565b5060028054600160a060020a031916600160a060020a0385161790556003829055600481805161014e929160200190610171565b5050505050610209565b73084f6a99003dae6d3906664fdbf43dd09930d0e35b90565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106101b257805160ff19168380011785556101df565b828001600101855582156101df579182015b828111156101df5782518255916020019190600101906101c4565b506101eb9291506101ef565b5090565b61016e91905b808211156101eb57600081556001016101f5565b610770806102186000396000f3006060604052600436106100ae5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166305db541d81146100b3578063060057541461013d57806312065fe01461016c57806327d3580114610191578063326401cf146101a457806341c0e1b5146101b757806359babde5146101cc5780639b26ef1714610224578063a550f86d146102c5578063a6f9dae1146102db578063c62f8db2146102fa575b600080fd5b34156100be57600080fd5b6100c6610352565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156101025780820151838201526020016100ea565b50505050905090810190601f16801561012f5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561014857600080fd5b6101506103f0565b604051600160a060020a03909116815260200160405180910390f35b341561017757600080fd5b61017f610409565b60405190815260200160405180910390f35b341561019c57600080fd5b6100c661042c565b34156101af57600080fd5b610150610497565b34156101c257600080fd5b6101ca6104a6565b005b34156101d757600080fd5b6101ca60046024813581810190830135806020601f82018190048102016040519081016040528181529291906020840183838082843750949650508435946020013593506104e892505050565b341561022f57600080fd5b6101ca60048035600160a060020a03169060446024803590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284375094965061053f95505050505050565b34156102d057600080fd5b61015060043561058a565b34156102e657600080fd5b6101ca600160a060020a036004351661061b565b341561030557600080fd5b6101ca60046024813581810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496505084359460200135935061066592505050565b60048054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103e85780601f106103bd576101008083540402835291602001916103e8565b820191906000526020600020905b8154815290600101906020018083116103cb57829003601f168201915b505050505081565b73084f6a99003dae6d3906664fdbf43dd09930d0e35b90565b6000805433600160a060020a0390811691161461042557600080fd5b5060035490565b60018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103e85780601f106103bd576101008083540402835291602001916103e8565b600254600160a060020a031681565b60005433600160a060020a039081169116146104c157600080fd5b60005433600160a060020a03908116911614156104e657600054600160a060020a0316ff5b565b6003548211156104f757600080fd5b6003805483900390557f098e541f764772513aa8ccd611cb4963758156bfc1712852cd585eece3ff0990828260405191825260208201526040908101905180910390a1505050565b60018280516105529291602001906106ac565b50506002805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039390931692909217909155506000600355565b60006105946103f0565b600160a060020a031663bb34534c836000604051602001526040517c010000000000000000000000000000000000000000000000000000000063ffffffff84160281526004810191909152602401602060405180830381600087803b15156105fb57600080fd5b6102c65a03f1151561060c57600080fd5b50505060405180519392505050565b60005433600160a060020a0390811691161461063657600080fd5b6000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b60038054830190557f098e541f764772513aa8ccd611cb4963758156bfc1712852cd585eece3ff0990828260405191825260208201526040908101905180910390a1505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106106ed57805160ff191683800117855561071a565b8280016001018555821561071a579182015b8281111561071a5782518255916020019190600101906106ff565b5061072692915061072a565b5090565b61040691905b8082111561072657600081556001016107305600a165627a7a7230582009abe6318948c75458498417ee70fa74119e5fc94a4a13e94a8b2e9a70d53f790029";

    protected Stash_sol_Stash(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Stash_sol_Stash(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<BalanceChangedEventResponse> getBalanceChangedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("BalanceChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
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
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
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

    public RemoteCall<String> stashType() {
        Function function = new Function("stashType", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> nameRegAddress() {
        Function function = new Function(
                "nameRegAddress", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getBalance() {
        Function function = new Function(
                "getBalance", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> bankName() {
        Function function = new Function("bankName", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> bankAddr() {
        Function function = new Function("bankAddr", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> kill() {
        Function function = new Function(
                "kill", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> debit(String _bankName, BigInteger _dAmt, BigInteger txnId) {
        Function function = new Function(
                "debit", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.generated.Uint256(_dAmt), 
                new org.web3j.abi.datatypes.generated.Uint256(txnId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setBank(String _bankAddr, String _bankName, String _stashType) {
        Function function = new Function(
                "setBank", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_bankAddr), 
                new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.Utf8String(_stashType)), 
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

    public RemoteCall<TransactionReceipt> changeOwner(String newOwner) {
        Function function = new Function(
                "changeOwner", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> credit(String _bankName, BigInteger _crAmt, BigInteger txnId) {
        Function function = new Function(
                "credit", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.generated.Uint256(_crAmt), 
                new org.web3j.abi.datatypes.generated.Uint256(txnId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Stash_sol_Stash> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _bankName, String _bankAddr, BigInteger _stashBalance, String _stashType) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.Address(_bankAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(_stashBalance), 
                new org.web3j.abi.datatypes.Utf8String(_stashType)));
        return deployRemoteCall(Stash_sol_Stash.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Stash_sol_Stash> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _bankName, String _bankAddr, BigInteger _stashBalance, String _stashType) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.Address(_bankAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(_stashBalance), 
                new org.web3j.abi.datatypes.Utf8String(_stashType)));
        return deployRemoteCall(Stash_sol_Stash.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Stash_sol_Stash load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Stash_sol_Stash(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Stash_sol_Stash load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Stash_sol_Stash(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class BalanceChangedEventResponse {
        public BigInteger amount;

        public BigInteger txID;
    }
}
