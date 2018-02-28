package com.aaron.util.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 检测ip:port 是否正常连接（单个线程）
 * 
 * @author Aaron
 * @date 2018年2月28日
 * @version 1.0
 * @package_type com.aaron.util.socket.CheckIpAndPortConnect
 */
public class CheckIpAndPortConnect {

	public static void main(String[] args) {
		String host = "192.168.128.129";
		int port = 9200;
		System.out.println(isHostConnectable(host, port));
	}

	/**
	 * 单个host:port
	 * 
	 * @param host
	 * @param port
	 * @return
	 */
	public static boolean isHostConnectable(String host, int port) {
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(host, port));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}
