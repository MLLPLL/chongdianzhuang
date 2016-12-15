package com.niuniu.superadapter.operator;

import java.util.ArrayList;
import java.util.List;

import com.niuniu.superadapter.operator.hlht.HlhtOperator;
import com.niuniu.superadapter.operator.xinxin.XinxinOperator;

public class OperatorFactory {
	private static NiuniuOperator HLHT = new HlhtOperator();
	private static NiuniuOperator XINXIN = new XinxinOperator();
	private static List<NiuniuOperator> ALLOPERATORS = new ArrayList<NiuniuOperator>();
	static {
		ALLOPERATORS.add(HLHT);
		ALLOPERATORS.add(XINXIN);
	}
	private OperatorFactory(){
		
	}	

	public static NiuniuOperator getOperator(String operator_type) throws Exception{
		if("hlht".equals(operator_type)){
			return HLHT;
		}else if("xinxin".equals(operator_type)){
			return XINXIN;
		}else{
			throw new Exception();
		}
	}
	
	public static List<NiuniuOperator> getAllOperators() throws Exception{
		if(2 != ALLOPERATORS.size()){
			throw new Exception();
		}
		return ALLOPERATORS;
	}
}
