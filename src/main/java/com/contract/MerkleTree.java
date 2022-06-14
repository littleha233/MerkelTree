package com.contract;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class MerkleTree extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506104d8806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c80630b8b1b4f1461003b578063797b377d1461006b575b600080fd5b61005560048036038101906100509190610258565b61009b565b604051610062919061034c565b60405180910390f35b610085600480360381019061008091906102ac565b6100b8565b6040516100929190610331565b60405180910390f35b60006100b082846100d890919063ffffffff16565b905092915050565b60006100cf8383866101549092919063ffffffff16565b90509392505050565b60008082905060005b84518110156101495761013482868381518110610127577f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b602002602001015161016b565b91508080610141906103e4565b9150506100e1565b508091505092915050565b60008261016185846100d8565b1490509392505050565b60008183106101835761017e8284610196565b61018e565b61018d8383610196565b5b905092915050565b600082600052816020526040600020905092915050565b60006101c06101bb84610398565b610367565b905080838252602082019050828560208602820111156101df57600080fd5b60005b8581101561020f57816101f58882610243565b8452602084019350602083019250506001810190506101e2565b5050509392505050565b600082601f83011261022a57600080fd5b813561023a8482602086016101ad565b91505092915050565b6000813590506102528161048b565b92915050565b6000806040838503121561026b57600080fd5b600083013567ffffffffffffffff81111561028557600080fd5b61029185828601610219565b92505060206102a285828601610243565b9150509250929050565b6000806000606084860312156102c157600080fd5b600084013567ffffffffffffffff8111156102db57600080fd5b6102e786828701610219565b93505060206102f886828701610243565b925050604061030986828701610243565b9150509250925092565b61031c816103c4565b82525050565b61032b816103d0565b82525050565b60006020820190506103466000830184610313565b92915050565b60006020820190506103616000830184610322565b92915050565b6000604051905081810181811067ffffffffffffffff8211171561038e5761038d61045c565b5b8060405250919050565b600067ffffffffffffffff8211156103b3576103b261045c565b5b602082029050602081019050919050565b60008115159050919050565b6000819050919050565b6000819050919050565b60006103ef826103da565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8214156104225761042161042d565b5b600182019050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b610494816103d0565b811461049f57600080fd5b5056fea26469706673582212206c3b04fb6d6d440d44ce7544a06dcf4a3443705e035e97b83f562d7fc413e29864736f6c63430008000033";

    public static final String FUNC_MTVERIFY = "mtVerify";

    public static final String FUNC_REBUITROOT = "rebuitRoot";

    @Deprecated
    protected MerkleTree(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MerkleTree(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MerkleTree(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MerkleTree(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> mtVerify(List<byte[]> proof, byte[] root, byte[] leaf) {
        final Function function = new Function(FUNC_MTVERIFY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(proof, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(root), 
                new org.web3j.abi.datatypes.generated.Bytes32(leaf)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<byte[]> rebuitRoot(List<byte[]> proof, byte[] leaf) {
        final Function function = new Function(FUNC_REBUITROOT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(proof, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(leaf)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    @Deprecated
    public static MerkleTree load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MerkleTree(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MerkleTree load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MerkleTree(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MerkleTree load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MerkleTree(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MerkleTree load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MerkleTree(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MerkleTree> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MerkleTree.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MerkleTree> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MerkleTree.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MerkleTree> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MerkleTree.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MerkleTree> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MerkleTree.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
