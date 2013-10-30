package cn.ohyeah.gameclient.global;

public class Constant {
	
	/**
	 * 协议版本
	 */
	public static final short PROTOCOL_VERSION = 1;
	
	/**
	 * 协议标志
	 */
	public static final short PROTOCOL_TAG_SYS_SERV = 0; 					/* 系统服务协议 */
	public static final short PROTOCOL_TAG_USER_SERV = 1; 					/* 用户服务协议 */
	public static final short PROTOCOL_TAG_PRIZE_SERV = 2; 					/* 奖品服务协议 */
	public static final short PROTOCOL_TAG_RECORD_SERV = 3;					/* 游戏记录服务 */
	
	/**
	 * 协议命令
	 */
	public static final short SYS_SERV_BREAK_HREAT = 1;					/*心跳命令*/
	
	public static final short USER_SERV_REGISTER = 11;					/*用户注册*/
	public static final short USER_SERV_LOGIN = 12;						/*用户登入*/
	
	public static final short PRIZE_SERV_LOAD_INFO = 21; 				/* 获取奖品信息*/
	public static final short PRIZE_SERV_LOAD_RES = 22; 				/* 获取奖品图片资源*/
	
	public static final short RECORD_SERV_SAVE = 31;					/* 保存游戏 记录 */
	public static final short RECORD_SERV_LOAD = 32;					/* 读取游戏记录 */
	
	public static final short TYPE_NOTICE = 0;
	public static final short TYPE_RESULTMSG = 1;
	public static final short TYPE_PRIZEMSG = 2;
	
	/**
	 * 协议名列表
	 * @author Administrator
	 *
	 */
	private static enum protocolTags {
		System, User, Prize
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
