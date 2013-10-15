package cn.ohyeah.gameclient.message;

import java.util.List;

import cn.ohyeah.gameclient.model.Prize;

public class PrizeMsg {

	/**
	 * 返回码， 0请求成功，负值为请求错误
	 */
	private int code;
	
	/**
	 * 提示信息，对应code值
	 */
	private String message;
	
	/**
	 * 存放奖品
	 */
	private List<Prize> prizes;

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

	public List<Prize> getPrizes() {
		return prizes;
	}

	public void setPrizes(List<Prize> prizes) {
		this.prizes = prizes;
	}
	
	
}
