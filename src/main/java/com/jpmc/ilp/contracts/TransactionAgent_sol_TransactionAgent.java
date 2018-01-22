package com.jpmc.ilp.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple9;
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
public class TransactionAgent_sol_TransactionAgent extends Contract {
    private static final String BINARY = "606060405234156200001057600080fd5b60008054600160a060020a03191633600160a060020a031617815560035560408051908101604052600881527f53555350454e5345000000000000000000000000000000000000000000000000602082015260059080516200007792916020019062000112565b5060408051908101604052600981527f434f4e4e4543544f52000000000000000000000000000000000000000000000060208201526007908051620000c192916020019062000112565b5060408051908101604052600a81527f504f534954494f4e414c00000000000000000000000000000000000000000000602082015260069080516200010b92916020019062000112565b50620001b7565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200015557805160ff191683800117855562000185565b8280016001018555821562000185579182015b828111156200018557825182559160200191906001019062000168565b506200019392915062000197565b5090565b620001b491905b808211156200019357600081556001016200019e565b90565b61229080620001c76000396000f300606060405260043610620000ad5763ffffffff60e060020a6000350416631eda70918114620000b257806336615d211462000122578063519cf67a146200018a57806353a0c83a14620003c757806363a8374d14620004285780636694843014620004bb5780636b43c9e414620006a45780639ace38c214620006fd5780639ba3d71614620009db578063a15d96d31462000a71578063a2577e171462000ac5578063a6f9dae11462000adb575b600080fd5b3415620000be57600080fd5b6200010660046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965062000afd95505050505050565b604051600160a060020a03909116815260200160405180910390f35b34156200012e57600080fd5b6200017660046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965062000c8395505050505050565b604051901515815260200160405180910390f35b34156200019657600080fd5b620003b560046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001909190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284375094965062000d7a95505050505050565b60405190815260200160405180910390f35b3415620003d357600080fd5b6200042660046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965050509235600160a060020a03169250620010c3915050565b005b34156200043457600080fd5b62000441600435620012d8565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156200047f57808201518382015260200162000465565b50505050905090810190601f168015620004ad5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3415620004c757600080fd5b620003b560046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001909190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405281815292919060208401838380828437509496506200138c95505050505050565b3415620006b057600080fd5b620003b5600480359060446024803590810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496506200165195505050505050565b34156200070957600080fd5b620007166004356200165b565b604051808a60028111156200072757fe5b60ff16815260200180602001806020018060200180602001898152602001806020018860038111156200075657fe5b60ff16815287151560208201526040878203810187528f54600260018216156101000260001901909116049082018190526060909101908f908015620007e05780601f10620007b457610100808354040283529160200191620007e0565b820191906000526020600020905b815481529060010190602001808311620007c257829003601f168201915b505086810385528d54600260001961010060018416150201909116048082526020909101908e908015620008585780601f106200082c5761010080835404028352916020019162000858565b820191906000526020600020905b8154815290600101906020018083116200083a57829003601f168201915b505086810384528c54600260001961010060018416150201909116048082526020909101908d908015620008d05780601f10620008a457610100808354040283529160200191620008d0565b820191906000526020600020905b815481529060010190602001808311620008b257829003601f168201915b505086810383528b54600260001961010060018416150201909116048082526020909101908c908015620009485780601f106200091c5761010080835404028352916020019162000948565b820191906000526020600020905b8154815290600101906020018083116200092a57829003601f168201915b505086810382528954600260001961010060018416150201909116048082526020909101908a908015620009c05780601f106200099457610100808354040283529160200191620009c0565b820191906000526020600020905b815481529060010190602001808311620009a257829003601f168201915b50509e50505050505050505050505050505060405180910390f35b3415620009e757600080fd5b6200010660046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528181529291906020840183838082843750949650620016a395505050505050565b341562000a7d57600080fd5b6200010660046024813581810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496506200179895505050505050565b341562000ad157600080fd5b62000106620017ce565b341562000ae757600080fd5b62000426600160a060020a0360043516620017de565b6000806009836040518082805190602001908083835b6020831062000b345780518252601f19909201916020918201910162000b13565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405190819003902054600160a060020a0316905060008163326401cf82604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b151562000bb357600080fd5b6102c65a03f1151562000bc557600080fd5b50505060405180519050600160a060020a03161415801562000c73575060005433600160a060020a039081169116148062000c73575033600160a060020a031681600160a060020a031663326401cf6000604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b151562000c4c57600080fd5b6102c65a03f1151562000c5e57600080fd5b50505060405180519050600160a060020a0316145b15620000ad578091505b50919050565b6000806008836040518082805190602001908083835b6020831062000cba5780518252601f19909201916020918201910162000c99565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405190819003902054600160a060020a0316905060008163326401cf82604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b151562000d3957600080fd5b6102c65a03f1151562000d4b57600080fd5b50505060405180519050600160a060020a031614151562000d70576001915062000c7d565b6000915062000c7d565b600080600062000d8b8c8c620016a3565b915062000d998a8a620016a3565b905081600160a060020a03166359babde58d8a6003600081546001019190508190556040518463ffffffff1660e060020a0281526004018080602001848152602001838152602001828103825285818151815260200191508051906020019080838360005b8381101562000e1857808201518382015260200162000dfe565b50505050905090810190601f16801562000e465780820380516001836020036101000a031916815260200191505b50945050505050600060405180830381600087803b151562000e6757600080fd5b6102c65a03f1151562000e7957600080fd5b50505080600160a060020a031663c62f8db28b8a6003546040518463ffffffff1660e060020a0281526004018080602001848152602001838152602001828103825285818151815260200191508051906020019080838360005b8381101562000eed57808201518382015260200162000ed3565b50505050905090810190601f16801562000f1b5780820380516001836020036101000a031916815260200191505b50945050505050600060405180830381600087803b151562000f3c57600080fd5b6102c65a03f1151562000f4e57600080fd5b50505061012060405190810160405280600281526020018d81526020018b81526020018781526020018681526020018981526020018881526020016000600381111562000f9757fe5b815260016020918201819052600354600090815291526040902081518154829060ff1916600183600281111562000fca57fe5b021790555060208201518160010190805162000feb92916020019062001829565b506040820151816002019080516200100892916020019062001829565b506060820151816003019080516200102592916020019062001829565b506080820151816004019080516200104292916020019062001829565b5060a0820151816005015560c0820151816006019080516200106992916020019062001829565b5060e082015160078201805460ff191660018360038111156200108857fe5b0217905550610100820151600790910180549115156101000261ff001990921691909117905550600354925050509998505050505050505050565b6000806008846040518082805190602001908083835b60208310620010fa5780518252601f199092019160209182019101620010d9565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405190819003902054600160a060020a0316146200114357600080fd5b8282600962001151620018ae565b600160a060020a038316602082015260408101829052608080825281906060820190820186818151815260200191508051906020019080838360005b83811015620011a75780820151838201526020016200118d565b50505050905090810190601f168015620011d55780820380516001836020036101000a031916815260200191505b50928303905250600881527f53555350454e534500000000000000000000000000000000000000000000000060208201526040908101935091505051809103906000f08015156200122557600080fd5b90507fc2e5fdb2e486babd662c44b305b51a7c0acaf246695da50b29863dba5b69edad8383604051600160a060020a038216602082015260408082528190810184818151815260200191508051906020019080838360005b83811015620012975780820151838201526020016200127d565b50505050905090810190601f168015620012c55780820380516001836020036101000a031916815260200191505b50935050505060405180910390a1505050565b60026020528060005260406000206000915090508054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015620013845780601f10620013585761010080835404028352916020019162001384565b820191906000526020600020905b8154815290600101906020018083116200136657829003601f168201915b505050505081565b60008060006200139c8b62001798565b91506000600160a060020a03831663326401cf82604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b1515620013e657600080fd5b6102c65a03f11515620013f857600080fd5b50505060405180519050600160a060020a031614156200141757600080fd5b620014228b62000afd565b90508982600160a060020a03166312065fe06000604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b15156200146c57600080fd5b6102c65a03f115156200147e57600080fd5b5050506040518051905010156200149457600080fd5b620015e38b60068054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015620015335780601f10620015075761010080835404028352916020019162001533565b820191906000526020600020905b8154815290600101906020018083116200151557829003601f168201915b50505050508d60058054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015620015d35780601f10620015a757610100808354040283529160200191620015d3565b820191906000526020600020905b815481529060010190602001808311620015b557829003601f168201915b50505050508e8e8c8c8c62000d7a565b600381905560009081526002602052604090208480516200160992916020019062001829565b507fe51eafa63abe5cb9e16dd543400581631addc6efc32ec62dafe1e04a9995ed0d60035460405190815260200160405180910390a150506003549998505050505050505050565b6003545b92915050565b600160208190526000918252604090912080546005820154600783015460ff928316948401936002810193600382019360048301939092600601918181169161010090041689565b600060056040518082805460018160011615610100020316600290048015620017065780601f10620016e357610100808354040283529182019162001706565b820191906000526020600020905b815481529060010190602001808311620016f1575b5050915050604051908190039020826040518082805190602001908083835b60208310620017465780518252601f19909201916020918201910162001725565b6001836020036101000a038019825116818451161790925250505091909101925060409150505190819003902014156200178d57620017858362001798565b905062001655565b620017858362000afd565b6000806008836040518082805190602001908083836020831062000b345780518252601f19909201916020918201910162000b13565b600454600160a060020a03165b90565b60005433600160a060020a03908116911614620017fa57600080fd5b6000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200186c57805160ff19168380011785556200189c565b828001600101855582156200189c579182015b828111156200189c5782518255916020019190600101906200187f565b50620018aa929150620018bf565b5090565b60405161098880620018dd83390190565b620017db91905b80821115620018aa5760008155600101620018c656006060604052341561000f57600080fd5b60405161098838038061098883398101604052808051820191906020018051919060200180519190602001805160008054600160a060020a03191633600160a060020a03161790559190910190507f537461736800000000000000000000000000000000000000000000000000000061009364010000000061015881026103f01704565b600160a060020a031663e1fa8e84826040517c010000000000000000000000000000000000000000000000000000000063ffffffff84160281526004810191909152602401600060405180830381600087803b15156100f157600080fd5b6102c65a03f1151561010257600080fd5b5050505083600190805161011a929160200190610171565b5060028054600160a060020a031916600160a060020a0385161790556003829055600481805161014e929160200190610171565b5050505050610209565b73084f6a99003dae6d3906664fdbf43dd09930d0e35b90565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106101b257805160ff19168380011785556101df565b828001600101855582156101df579182015b828111156101df5782518255916020019190600101906101c4565b506101eb9291506101ef565b5090565b61016e91905b808211156101eb57600081556001016101f5565b610770806102186000396000f3006060604052600436106100ae5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166305db541d81146100b3578063060057541461013d57806312065fe01461016c57806327d3580114610191578063326401cf146101a457806341c0e1b5146101b757806359babde5146101cc5780639b26ef1714610224578063a550f86d146102c5578063a6f9dae1146102db578063c62f8db2146102fa575b600080fd5b34156100be57600080fd5b6100c6610352565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156101025780820151838201526020016100ea565b50505050905090810190601f16801561012f5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561014857600080fd5b6101506103f0565b604051600160a060020a03909116815260200160405180910390f35b341561017757600080fd5b61017f610409565b60405190815260200160405180910390f35b341561019c57600080fd5b6100c661042c565b34156101af57600080fd5b610150610497565b34156101c257600080fd5b6101ca6104a6565b005b34156101d757600080fd5b6101ca60046024813581810190830135806020601f82018190048102016040519081016040528181529291906020840183838082843750949650508435946020013593506104e892505050565b341561022f57600080fd5b6101ca60048035600160a060020a03169060446024803590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284375094965061053f95505050505050565b34156102d057600080fd5b61015060043561058a565b34156102e657600080fd5b6101ca600160a060020a036004351661061b565b341561030557600080fd5b6101ca60046024813581810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496505084359460200135935061066592505050565b60048054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103e85780601f106103bd576101008083540402835291602001916103e8565b820191906000526020600020905b8154815290600101906020018083116103cb57829003601f168201915b505050505081565b73084f6a99003dae6d3906664fdbf43dd09930d0e35b90565b6000805433600160a060020a0390811691161461042557600080fd5b5060035490565b60018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103e85780601f106103bd576101008083540402835291602001916103e8565b600254600160a060020a031681565b60005433600160a060020a039081169116146104c157600080fd5b60005433600160a060020a03908116911614156104e657600054600160a060020a0316ff5b565b6003548211156104f757600080fd5b6003805483900390557f098e541f764772513aa8ccd611cb4963758156bfc1712852cd585eece3ff0990828260405191825260208201526040908101905180910390a1505050565b60018280516105529291602001906106ac565b50506002805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039390931692909217909155506000600355565b60006105946103f0565b600160a060020a031663bb34534c836000604051602001526040517c010000000000000000000000000000000000000000000000000000000063ffffffff84160281526004810191909152602401602060405180830381600087803b15156105fb57600080fd5b6102c65a03f1151561060c57600080fd5b50505060405180519392505050565b60005433600160a060020a0390811691161461063657600080fd5b6000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b60038054830190557f098e541f764772513aa8ccd611cb4963758156bfc1712852cd585eece3ff0990828260405191825260208201526040908101905180910390a1505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106106ed57805160ff191683800117855561071a565b8280016001018555821561071a579182015b8281111561071a5782518255916020019190600101906106ff565b5061072692915061072a565b5090565b61040691905b8082111561072657600081556001016107305600a165627a7a7230582009abe6318948c75458498417ee70fa74119e5fc94a4a13e94a8b2e9a70d53f790029a165627a7a72305820462c0f9f3270cefb52348e328a952d71bdffd55261e15d9bb7a0e4bc201fbc220029";

    protected TransactionAgent_sol_TransactionAgent(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TransactionAgent_sol_TransactionAgent(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<StashCreatedEventResponse> getStashCreatedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("StashCreated", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<StashCreatedEventResponse> responses = new ArrayList<StashCreatedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            StashCreatedEventResponse typedResponse = new StashCreatedEventResponse();
            typedResponse._name = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._bank = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<StashCreatedEventResponse> stashCreatedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("StashCreated", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, StashCreatedEventResponse>() {
            @Override
            public StashCreatedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                StashCreatedEventResponse typedResponse = new StashCreatedEventResponse();
                typedResponse._name = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._bank = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<InitIlpTransferEventResponse> getInitIlpTransferEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("InitIlpTransfer", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<InitIlpTransferEventResponse> responses = new ArrayList<InitIlpTransferEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            InitIlpTransferEventResponse typedResponse = new InitIlpTransferEventResponse();
            typedResponse.trnsactionId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<InitIlpTransferEventResponse> initIlpTransferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("InitIlpTransfer", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, InitIlpTransferEventResponse>() {
            @Override
            public InitIlpTransferEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                InitIlpTransferEventResponse typedResponse = new InitIlpTransferEventResponse();
                typedResponse.trnsactionId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<SupenseAccountCreditRequestEventResponse> getSupenseAccountCreditRequestEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("SupenseAccountCreditRequest", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<SupenseAccountCreditRequestEventResponse> responses = new ArrayList<SupenseAccountCreditRequestEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            SupenseAccountCreditRequestEventResponse typedResponse = new SupenseAccountCreditRequestEventResponse();
            typedResponse.transactionId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SupenseAccountCreditRequestEventResponse> supenseAccountCreditRequestEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("SupenseAccountCreditRequest", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SupenseAccountCreditRequestEventResponse>() {
            @Override
            public SupenseAccountCreditRequestEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                SupenseAccountCreditRequestEventResponse typedResponse = new SupenseAccountCreditRequestEventResponse();
                typedResponse.transactionId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<ConfirmPaymentAtDestinationEventResponse> getConfirmPaymentAtDestinationEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("confirmPaymentAtDestination", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ConfirmPaymentAtDestinationEventResponse> responses = new ArrayList<ConfirmPaymentAtDestinationEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ConfirmPaymentAtDestinationEventResponse typedResponse = new ConfirmPaymentAtDestinationEventResponse();
            typedResponse.trnsactionId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ConfirmPaymentAtDestinationEventResponse> confirmPaymentAtDestinationEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("confirmPaymentAtDestination", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ConfirmPaymentAtDestinationEventResponse>() {
            @Override
            public ConfirmPaymentAtDestinationEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ConfirmPaymentAtDestinationEventResponse typedResponse = new ConfirmPaymentAtDestinationEventResponse();
                typedResponse.trnsactionId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<ConfirmIlpPaymentResponseEventResponse> getConfirmIlpPaymentResponseEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("confirmIlpPaymentResponse", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ConfirmIlpPaymentResponseEventResponse> responses = new ArrayList<ConfirmIlpPaymentResponseEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ConfirmIlpPaymentResponseEventResponse typedResponse = new ConfirmIlpPaymentResponseEventResponse();
            typedResponse._paymentId = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.trnsactionId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ConfirmIlpPaymentResponseEventResponse> confirmIlpPaymentResponseEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("confirmIlpPaymentResponse", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ConfirmIlpPaymentResponseEventResponse>() {
            @Override
            public ConfirmIlpPaymentResponseEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ConfirmIlpPaymentResponseEventResponse typedResponse = new ConfirmIlpPaymentResponseEventResponse();
                typedResponse._paymentId = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.trnsactionId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> getBanksSuspenseStash(String _bankName) {
        Function function = new Function(
                "getBanksSuspenseStash", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> doesStashExist(String _bankName) {
        Function function = new Function(
                "doesStashExist", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createTransfer(String _origBankName, String _origStashType, String _destBankName, String _destStashType, BigInteger _transactionAmt, String _remarks, String sourceCurrency, String destinationCurrency, String paymentId) {
        Function function = new Function(
                "createTransfer", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_origBankName), 
                new org.web3j.abi.datatypes.Utf8String(_origStashType), 
                new org.web3j.abi.datatypes.Utf8String(_destBankName), 
                new org.web3j.abi.datatypes.Utf8String(_destStashType), 
                new org.web3j.abi.datatypes.generated.Uint256(_transactionAmt), 
                new org.web3j.abi.datatypes.Utf8String(_remarks), 
                new org.web3j.abi.datatypes.Utf8String(sourceCurrency), 
                new org.web3j.abi.datatypes.Utf8String(destinationCurrency), 
                new org.web3j.abi.datatypes.Utf8String(paymentId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createBankStash(String _bankName, String _bankAddress) {
        Function function = new Function(
                "createBankStash", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.Address(_bankAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> pendingTransactions(BigInteger param0) {
        Function function = new Function("pendingTransactions", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> initIlpTransfer(String _origBankName, BigInteger _txnAmt, String _remarks, String _origAccountAddress, String _destAccountAddress, String sourceCurrency, String destinationCurrency, String paymentId) {
        Function function = new Function(
                "initIlpTransfer", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_origBankName), 
                new org.web3j.abi.datatypes.generated.Uint256(_txnAmt), 
                new org.web3j.abi.datatypes.Utf8String(_remarks), 
                new org.web3j.abi.datatypes.Utf8String(_origAccountAddress), 
                new org.web3j.abi.datatypes.Utf8String(_destAccountAddress), 
                new org.web3j.abi.datatypes.Utf8String(sourceCurrency), 
                new org.web3j.abi.datatypes.Utf8String(destinationCurrency), 
                new org.web3j.abi.datatypes.Utf8String(paymentId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> rejectTransfer(BigInteger _transactionNum, String _remarks) {
        Function function = new Function(
                "rejectTransfer", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_transactionNum), 
                new org.web3j.abi.datatypes.Utf8String(_remarks)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple9<BigInteger, String, String, String, String, BigInteger, String, BigInteger, Boolean>> transactions(BigInteger param0) {
        final Function function = new Function("transactions", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple9<BigInteger, String, String, String, String, BigInteger, String, BigInteger, Boolean>>(
                new Callable<Tuple9<BigInteger, String, String, String, String, BigInteger, String, BigInteger, Boolean>>() {
                    @Override
                    public Tuple9<BigInteger, String, String, String, String, BigInteger, String, BigInteger, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple9<BigInteger, String, String, String, String, BigInteger, String, BigInteger, Boolean>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue(), 
                                (Boolean) results.get(8).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> getStash(String _bankName, String stashType) {
        Function function = new Function(
                "getStash", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.Utf8String(stashType)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getBankStash(String _bankName) {
        Function function = new Function(
                "getBankStash", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getConnectorStash() {
        Function function = new Function(
                "getConnectorStash", 
                Arrays.<Type>asList(), 
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

    public static RemoteCall<TransactionAgent_sol_TransactionAgent> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TransactionAgent_sol_TransactionAgent.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<TransactionAgent_sol_TransactionAgent> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TransactionAgent_sol_TransactionAgent.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static TransactionAgent_sol_TransactionAgent load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransactionAgent_sol_TransactionAgent(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static TransactionAgent_sol_TransactionAgent load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransactionAgent_sol_TransactionAgent(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class StashCreatedEventResponse {
        public String _name;

        public String _bank;
    }

    public static class InitIlpTransferEventResponse {
        public BigInteger trnsactionId;
    }

    public static class SupenseAccountCreditRequestEventResponse {
        public BigInteger transactionId;
    }

    public static class ConfirmPaymentAtDestinationEventResponse {
        public BigInteger trnsactionId;
    }

    public static class ConfirmIlpPaymentResponseEventResponse {
        public String _paymentId;

        public BigInteger trnsactionId;
    }
}
