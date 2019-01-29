package com.oberdan.listavip.error;

public class NaoEncontradoDetails extends ErroDetalhes {

	public static final class Builder {
		private long timestamp;
		private int status;
		private String message;

		private Builder() {
		}

		public static Builder newBuilder() {
			return new Builder();
		}

		public Builder timestamp(Long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder status(int status) {
			this.status = status;
			return this;
		}

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public NaoEncontradoDetails build() {
			NaoEncontradoDetails ned = new NaoEncontradoDetails();
			ned.setMessage(this.message);
			ned.setStatus(this.status);
			ned.setTimestamp(this.timestamp);
			return ned ;
		}

	}

}
