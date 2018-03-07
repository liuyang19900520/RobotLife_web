package com.liuyang19900520.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageVo<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String draw;

	// 总记录数
	private String recordsTotal;
	// 过滤后记录数
	private String recordsFiltered;

	private List<T> data;



}
