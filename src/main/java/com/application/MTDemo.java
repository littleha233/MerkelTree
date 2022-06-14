package com.application;

import org.web3j.crypto.CipherException;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.application.MTContractInvoke.merkleTreeVerify;
import static com.utils.String2ByteArr.String2BytesArr;

public class MTDemo {

    public static void main(String[] args) throws IOException, CipherException, ExecutionException, InterruptedException {

        // 构造MT树，通过使用工具 MerkleTree.js-cli生成，keccak256哈希方法
        // 前四个是第一层叶子节点，后两个是第二层节点
        String [] merkleTree = {"0x3ac225168df54212a25c1c01fd35bebfea408fdac2e31ddd6f80a4bbf9a5f1cb",
                "0xb5553de315e0edf504d9150af82dafa5c4667fa618ed0a6f19c69b41166c5510",
                "0x0b42b6393c1f53060fe3ddbfcd7aadcca894465a5a438f69c87d790b2299b9b2",
                "0xf1918e8562236eb17adc8502332f4c9c82bc14e19bfc0aa10ab674ff75b3d2f3",
                "0x805b21d846b189efaeb0377d6bb0d201b3872a363e607c25088f025b0c6ae1f8",
                "0xd253a52d4cb00de2895e85f2529e2976e6aaaa5c18106b68ab66813e14415669",
                "0x68203f90e9d07dc5859259d7536e87a6ba9d345f2552b5b9de2999ddce9ce1bf"};

        // 将第4个节点设置为待验证节点，即叶子节点
        String leaf = merkleTree[3];

        // 添加MT树路径上的proof节点
        // 可以通过程序实现自动选择
        String [] proof = {merkleTree[2],merkleTree[4]};

        String root = merkleTree[6];
        byte[] _root = String2BytesArr(root);
        // 构造输入参数
        byte[] _leaf = String2BytesArr(leaf);
        List<byte[]> _proof = new LinkedList<>();
        for (String str : proof){
            _proof.add(String2BytesArr(str));
        }

        // 重新计算根节点哈希
//        byte[] merkleTreeRoot = getMerkleTreeRoot(_proof, _leaf);
//        String root = BytesArr2String(merkleTreeRoot);
//        byte[] _root = String2BytesArr(root);

        // 验证某个leaf是否属于MT树
        boolean verificationResult = merkleTreeVerify(_proof, _root, _leaf);
        System.out.println("Whether leaf in MT? " + verificationResult);
    }

}
