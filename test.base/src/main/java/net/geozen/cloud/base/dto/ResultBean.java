package net.geozen.cloud.base.dto;

public class ResultBean<T> {
	private String msg;
	private String traceId;
	private T data;

	public ResultBean() {

	}

	public ResultBean(T data) {
		this.data = data;
	}

	public ResultBean(String traceId, String msg) {
		this.traceId = traceId;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
