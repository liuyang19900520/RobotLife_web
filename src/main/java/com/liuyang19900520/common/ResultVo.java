package com.liuyang19900520.common;

import lombok.Data;

/**
 * rest接口返回数据对象
 * @author liuya
 */
@Data
public class ResultVo {
	/**
	 * 结果-1 失败，1-成功
	 */
	private int ret;
	/**
	 * 结果代码
	 */
	private String code;
	/**
	 * 结果消息
	 */
	private String msg;
	/**
	 * 结果数据
	 */
	private Object data;
	
	public static final int SUCCESS = 1;
	public static final int FAILURE = 0;
	
	public ResultVo(int ret, String code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.ret = ret;
		this.data = data;
	}
	
	public ResultVo() {
		super();
	}


}
