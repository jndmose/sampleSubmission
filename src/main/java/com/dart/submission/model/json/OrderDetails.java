package com.dart.submission.model.json;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetails {
	@JsonProperty("orderId")
	private String orderId = null;
	@JsonProperty("numberOfSamples")
	private Integer numberOfSamples = null;
	@JsonProperty("clientId")
	private String clientId = null;
	@JsonProperty("requiredServiceInfo")
	private HashMap<String, Object> requiredServiceInfo = null;
	@JsonProperty("serviceId")
	private String serviceId = null;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getNumberOfSamples() {
		return numberOfSamples;
	}

	public void setNumberOfSamples(Integer numberOfSamples) {
		this.numberOfSamples = numberOfSamples;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Map<String, Object> getRequiredServiceInfo() {
		return requiredServiceInfo;
	}

	public void setRequiredServiceInfo(HashMap<String, Object> requiredServiceInfo) {
		this.requiredServiceInfo = requiredServiceInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((numberOfSamples == null) ? 0 : numberOfSamples.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((requiredServiceInfo == null) ? 0 : requiredServiceInfo.hashCode());
		result = prime * result + ((serviceId == null) ? 0 : serviceId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (numberOfSamples == null) {
			if (other.numberOfSamples != null)
				return false;
		} else if (!numberOfSamples.equals(other.numberOfSamples))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (requiredServiceInfo == null) {
			if (other.requiredServiceInfo != null)
				return false;
		} else if (!requiredServiceInfo.equals(other.requiredServiceInfo))
			return false;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderId=" + orderId + ", numberOfSamples=" + numberOfSamples + ", clientId=" + clientId
				+ ", serviceId=" + serviceId + ", requiredServiceInfo=" + requiredServiceInfo + "]";
	}

}
