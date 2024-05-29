package com.kpc.di;

public class Service02 {
	private int su1;
	private double su2;
	private char sh3;
	private boolean boo;
	private String msg;
	
	public Service02() {
	}

	public Service02(int su1, double su2, char sh3, boolean boo, String msg) {
		super();
		this.su1 = su1;
		this.su2 = su2;
		this.sh3 = sh3;
		this.boo = boo;
		this.msg = msg;
	}

	public int getSu1() {
		return su1;
	}

	public void setSu1(int su1) {
		this.su1 = su1;
	}

	public double getSu2() {
		return su2;
	}

	public void setSu2(double su2) {
		this.su2 = su2;
	}

	public char getSh3() {
		return sh3;
	}

	public void setSh3(char sh3) {
		this.sh3 = sh3;
	}

	public boolean isBoo() {
		return boo;
	}

	public void setBoo(boolean boo) {
		this.boo = boo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Service02 [su1=" + su1 + ", su2=" + su2 + ", sh3=" + sh3 + ", boo=" + boo + ", msg=" + msg + "]";
	}
	
}
