package cn.ohyeah.gameclient.message;

/**
 * 服务器返回的信息(客户端主动调用)
 * @author Administrator
 *
 */
public class ResultInfo {
	
	/**
	 * 返回码， 0请求成功，负值为请求错误
	 */
	private int code;
	
	/**
	 * 提示信息，对应code值
	 */
	private String message;
	
	/**
	 * 返回的数据
	 */
	private String data;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
