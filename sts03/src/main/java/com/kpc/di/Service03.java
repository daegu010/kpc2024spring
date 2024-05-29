package com.kpc.di;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Service03 {
	private int[] arr1;
	private List arr2;
	private Set arr3;
	private Map map1;
	private Properties map2;
	public void setArr1(int[] arr1) {
		this.arr1 = arr1;
	}
	public void setArr2(List arr2) {
		this.arr2 = arr2;
	}
	public void setArr3(Set arr3) {
		this.arr3 = arr3;
	}
	public void setMap1(Map map1) {
		this.map1 = map1;
	}
	public void setMap2(Properties map2) {
		this.map2 = map2;
	}
	
	@Override
	public String toString() {
		return "arr1="+Arrays.toString(arr1)+"\narr2="+arr2
				+"\narr3="+arr3+"\nmap1="+map1+"\nmap2="+map2;
	}
}
