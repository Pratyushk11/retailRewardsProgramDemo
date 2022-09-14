package com.pointgenerator.model;

public class Points {
    private long customerId;
	private double lastMonthPoints;
    private double lastSecondMonthPoints;
    private double lastThirdMonthPoints;
    private double totalPoints;
    
    
	public Points(long customerId, double lastMonthPoints, double lastSecondMonthPoints, double lastThirdMonthPoints,
			double totalPoints) {
		super();
		this.customerId = customerId;
		this.lastMonthPoints = lastMonthPoints;
		this.lastSecondMonthPoints = lastSecondMonthPoints;
		this.lastThirdMonthPoints = lastThirdMonthPoints;
		this.totalPoints = totalPoints;
	}
	
	@Override
	public String toString() {
		return "Points [customerId=" + customerId + ", lastMonthPoints=" + lastMonthPoints + ", lastSecondMonthPoints="
				+ lastSecondMonthPoints + ", lastThirdMonthPoints=" + lastThirdMonthPoints + ", totalPoints="
				+ totalPoints + "]";
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public double getLastMonthPoints() {
		return lastMonthPoints;
	}

	public void setLastMonthPoints(double lastMonthPoints) {
		this.lastMonthPoints = lastMonthPoints;
	}

	public double getLastSecondMonthPoints() {
		return lastSecondMonthPoints;
	}

	public void setLastSecondMonthPoints(double lastSecondMonthPoints) {
		this.lastSecondMonthPoints = lastSecondMonthPoints;
	}

	public double getLastThirdMonthPoints() {
		return lastThirdMonthPoints;
	}

	public void setLastThirdMonthPoints(double lastThirdMonthPoints) {
		this.lastThirdMonthPoints = lastThirdMonthPoints;
	}

	public double getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(double totalPoints) {
		this.totalPoints = totalPoints;
	}
	
   
}
