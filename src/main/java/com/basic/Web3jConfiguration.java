package com.basic;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

public class Web3jConfiguration {

    public static final String URL = "http://127.0.0.1:8545";

    //http服务
    public static HttpService getService(){
        return new HttpService(URL);
    }

    //初始化web3j对象
    public static Web3j initWeb3j(){
        return Web3j.build(getService());
    }


    public static void main(String[] args) throws IOException {
        Web3j web3j = initWeb3j();
        Web3ClientVersion send = web3j.web3ClientVersion().send();
        String version = send.getWeb3ClientVersion();
        System.out.println(version);
    }
}
