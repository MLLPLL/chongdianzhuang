package com.niuniu.superadapter.operator;

import java.util.ArrayList;
import java.util.List;

import com.niuniu.superadapter.operator.hlht.HlhtOperator;
import com.niuniu.superadapter.operator.xinxin.XinxinOperator;

public class OperatorFactory {
	private static OperatorStub HLHT = new HlhtOperator();
	private static OperatorStub XINXIN = new XinxinOperator();
	private static List<OperatorStub> ALLOPERATORS = new ArrayList<OperatorStub>();
	static {
		ALLOPERATORS.add(HLHT);
		ALLOPERATORS.add(XINXIN);
	}
	private OperatorFactory(){
		
	}	

	public static OperatorStub getOperator(String operator_type) throws Exception{
		if("hlht".equals(operator_type)){
			return HLHT;
		}else if("xinxin".equals(operator_type)){
			return XINXIN;
		}else{
			throw new Exception();
		}
	}
	
	public static List<OperatorStub> getAllOperators() throws Exception{
		if(2 != ALLOPERATORS.size()){
			throw new Exception();
		}
		return ALLOPERATORS;
	}
}
