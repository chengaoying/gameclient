package cn.ohyeah.gameclient.global;

public class Constant {
	
	/**
	 * 协议版本
	 */
	public static final byte PROTOCOL_VERSION = 1;
	
	/**
	 * 协议标志
	 */
	public static final byte PROTOCOL_TAG_SYS_SERV = 0; 		/* 系统服务协议 */
	public static final byte PROTOCOL_TAG_USER_SERV = 1; 		/* 用户服务协议 */
	
	/**
	 * 协议命令
	 */
	public static final byte  SYS_SERV_BREAK_HREAT = 1;			/*心跳命令*/
	
	public static final byte  USER_SERV_REGISTER = 11;			/*用户注册*/
	public static final byte  USER_SERV_LOGIN = 12;				/*用户注册*/
	
	/**
	 * 协议名列表
	 * @author Administrator
	 *
	 */
	private static enum protocolTags {
		System, User
	};
	
	public static String getProtocolName(int tag){
		return protocolTags.values()[tag].toString();
	}
	
	/**
	 * 获取协议名列表
	 * @return
	 */
	public static final String[] getProtocolList(){
		int len = protocolTags.values().length;
		String[] list = new String[len];
		for(int i=0;i<len;i++){
			list[i] = protocolTags.values()[i].toString();
		}
		return list;
	}
	
}
