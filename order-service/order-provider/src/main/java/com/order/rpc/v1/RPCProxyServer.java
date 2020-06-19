package com.order.rpc.v1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * RPC远程代理
 * 2020-06-18
 */
public class RPCProxyServer {
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(Object service,int port){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessHandler(socket, service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != serverSocket){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
