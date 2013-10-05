package cn.ohyeah.gameclient.message;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {

	/**
	 * 服务器返回的消息
	 */
	public static Queue<Message> msgQueue = new LinkedList<Message>();
	
	/**
	 * 服务器是否有消息返回，创建一个线程监听，有消息则告诉主线程。
	 * @return
	 */
	public static boolean hasMessage(){
		return !msgQueue.isEmpty();
	}
}
