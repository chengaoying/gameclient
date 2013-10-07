package cn.ohyeah.gameclient.message;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 消息队列，临时保存服务器返回的信息
 * @author xiao chen
 *
 */
public class MessageQueue {

	/**
	 * 客户端主动调用之后，服务器返回的消息
	 */
	public static Queue<ResultInfo> msgQueue = new LinkedList<ResultInfo>();
	
	/**
	 * 服务器向客户端发送的公告信息，被动接收
	 */
	public static Queue<Notice> noticeQueue = new LinkedList<Notice>();
	
	/**
	 * 服务器是否有消息返回
	 * @return
	 */
	public static boolean hasMessage(){
		return !msgQueue.isEmpty();
	}
	
	/**
	 * 是否用公告
	 * @return
	 */
	public static boolean hasNotice(){
		return !noticeQueue.isEmpty();
	}
}
