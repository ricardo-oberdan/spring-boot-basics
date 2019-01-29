package com.oberdan.listavip.error;

public class ErroDetalhes {
	private long timestamp;
	private int status;
	private String message;

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public ErroDetalhes build() {
		ErroDetalhes ed = new ErroDetalhes();
		ed.setMessage(this.message);
		ed.setStatus(this.status);
		ed.setTimestamp(this.timestamp);
		return ed;
	}
}
