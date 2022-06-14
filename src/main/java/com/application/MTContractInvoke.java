package com.application;

import com.contract.MerkleTree;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.tx.RawTransactionManager;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.basic.Web3jConfiguration.initWeb3j;

public class MTContractInvoke {

    // 初始化配置
    public static final BigInteger GAS_PRICE = BigInteger.valueOf(200000);
    public static final BigInteger GAS_LIMIT = BigInteger.valueOf(3000000);

    // Geth账户信息
    public static final String PWD = "testpwd";
    public static final String DIR = "src/main/resources/wallet/UTC--2022-06-13T03-38-09.774229000Z--d0cb3901d3a3635f339131ef7f46ef42ccd73a54";

    public static final String contractAddr = "0x0a726A252024565A9cD55E3F575A1CA1E8eC3a71";

    // 获取合约对象
    public static MerkleTree getContractObject() throws CipherException, IOException {
        Web3j web3j = initWeb3j();
        Credentials credentials = WalletUtils.loadCredentials(PWD, DIR);
        long chainID = 20191111;
        RawTransactionManager rawTransactionManager = new RawTransactionManager(web3j, credentials, chainID);
        return MerkleTree.load(contractAddr, web3j, rawTransactionManager, GAS_PRICE, GAS_LIMIT);
    }


    /**
     * 验证Merkle树
     * @param proof MT树上的路径证明，路径节点列表
     * @param root  MT树的根节点
     * @param leaf  MT树的叶子节点，也是待验证节点——验证该节点是否属于该MT树
     * @throws CipherException
     * @throws IOException
     */
    public static boolean merkleTreeVerify(List<byte[]> proof, byte[] root, byte[] leaf) throws CipherException, IOException, ExecutionException, InterruptedException {
        MerkleTree mt = getContractObject();
        CompletableFuture<Boolean> invokeResult = mt.mtVerify(proof, root, leaf).sendAsync();
        return invokeResult.get();
    }

    /**
     * 根据叶子节点（待验证节点）和MT路径节点重新计算 MT的根节点
     * @param proof MT树上的路径证明，路径节点列表
     * @param leaf MT树的叶子节点，也是待验证节点——验证该节点是否属于该MT树
     * @return
     * @throws CipherException
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static byte[] getMerkleTreeRoot(List<byte[]> proof, byte[] leaf) throws CipherException, IOException, ExecutionException, InterruptedException {
        MerkleTree mt = getContractObject();
        CompletableFuture<byte[]> invokeResult = mt.rebuitRoot(proof, leaf).sendAsync();
        byte[] result = invokeResult.get();
        System.out.println(result);
        return result;
    }

}
