1. #### 构造MerkleTree——获得层级结构和根哈希

   Merkletree.js-cli工具

   ```shell
   meng@FM ~ % merkletreejs --help            
     CLI for merkletreejs
       Usage
     $ merkletreejs [options]
       Options
         -h, --hash Hash function to use. Options are "sha256" (default), "keccak256".
         -l, --leaves JSON file containing array of leaves. Use "-" to read from stdin.
         --hash-leaves Hash leaves
         --sort Sort leaves and pairs
         --sort-leaves Sort leaves
         --sort-pairs Sort pairs when hashing nodes
         --duplicate-odd Duplicate odd nodes
         --fill-default-hash Fill default hash value
         -o --output Result to output. Options are "root", "leaves", "layers", "layers-flat", "tree" (default)
       Examples
         $ cat leaves.json | merkletreejs --leaves=- --hash=keccak256 --output=root
   ```

   开始使用

   ```shell
   // 输入MT树的叶子节点
   $ echo '["a", "b", "c"]' > leaves.json
   
   // 输出MT树的根哈希，依次指定叶子节点所在的json文件、使用到的哈希算法、对叶子进行哈希运算、对叶子进行排序、输出根哈希
   // 以太坊使用到的是keccak256哈希算法
   $ merkletreejs --leaves=leaves.json --hash=keccak256 --hash-leaves --sort-pairs --output=root
   0x5842148bc6ebeb52af882a317c765fccd3ae80589b21a9b8cbf21abb630e46a7
   
   // 输出MT树的层级关系，第一层是三个
   $ merkletreejs --leaves=leaves.json --hash=keccak256 --hash-leaves --sort-pairs --output=layers
   [
     [
       "0x3ac225168df54212a25c1c01fd35bebfea408fdac2e31ddd6f80a4bbf9a5f1cb",
       "0xb5553de315e0edf504d9150af82dafa5c4667fa618ed0a6f19c69b41166c5510",
       "0x0b42b6393c1f53060fe3ddbfcd7aadcca894465a5a438f69c87d790b2299b9b2"
     ],
     [
       "0x805b21d846b189efaeb0377d6bb0d201b3872a363e607c25088f025b0c6ae1f8",
       "0x0b42b6393c1f53060fe3ddbfcd7aadcca894465a5a438f69c87d790b2299b9b2"
     ],
     [
       "0x5842148bc6ebeb52af882a317c765fccd3ae80589b21a9b8cbf21abb630e46a7"
     ]
   ]
   ```



2. #### 验证MerkleTree的智能合约

   ```solidity
   // SPDX-License-Identifier: MIT
   pragma solidity ^0.8.0;
   
   import "@openzeppelin/contracts/utils/cryptography/MerkleProof.sol";
   
   contract MerkleTree{
   		/*
   			using MerkleTree for byte32[]是为byte32[]类型的数据扩展库中带有的功能，
   			using for实际上是导入库的关键语句
   		*/
       using MerkleProof for bytes32[];
       
       function mtVerify(bytes32[] memory proof, bytes32 root, bytes32 leaf) 
           public pure 
           returns (bool){
               return proof.verify(root, leaf);
       } 
   
       function rebuitRoot(bytes32[] memory proof, bytes32 leaf) 
           public view 
           returns (bytes32){
               return proof.processProof(leaf);
       }
   }
   ```

    - **byte32类型的参数如何传入？**

        1. byte32[]数组：**[]内使用“ ”进行标注**，如["0x3ac225168df54212a25c1c01fd35bebfea408fdac2e31ddd6f80a4bbf9a5f1cb","0xb5553de315e0edf504d9150af82dafa5c4667fa618ed0a6f19c69b41166c5510"].
        2. byte32类型：**直接放原始数据，不加引号**，如0x0b42b6393c1f53060fe3ddbfcd7aadcca894465a5a438f69c87d790b2299b9b2

    - **Proof数组的指定**：merkle路径上的所有的值，如

      [

      [

      "0x3ac225168df54212a25c1c01fd35bebfea408fdac2e31ddd6f80a4bbf9a5f1cb",

      "0xb5553de315e0edf504d9150af82dafa5c4667fa618ed0a6f19c69b41166c5510",

      **"0x0b42b6393c1f53060fe3ddbfcd7aadcca894465a5a438f69c87d790b2299b9b2", **【*proof【0】*】

      "0xf1918e8562236eb17adc8502332f4c9c82bc14e19bfc0aa10ab674ff75b3d2f3"   【*leaf*】

      ],

      [

      **"0x805b21d846b189efaeb0377d6bb0d201b3872a363e607c25088f025b0c6ae1f8",** 【*proof【1】*】

      "0xd253a52d4cb00de2895e85f2529e2976e6aaaa5c18106b68ab66813e14415669"

      ],

      [

      "0x68203f90e9d07dc5859259d7536e87a6ba9d345f2552b5b9de2999ddce9ce1bf" 【*Root*】

      ]

      ]