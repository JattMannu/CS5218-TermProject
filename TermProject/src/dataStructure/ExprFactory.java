/**
 * 
 */
package dataStructure;
//import java.lang.reflect.*;
//import dataStructure.*;
import dataStructure.Program.AbstractExpr;

import java.util.Map;
import java.util.HashMap;

/**
 * @author WuJun A0106507M
 *
 */
public class ExprFactory {
	
	private Map<String, String> element2ClassName;
	
	public ExprFactory() {
		// TODO Auto-generated constructor stub
		element2ClassName = new HashMap<String, String>();
		for(int i = 0; !FactoryHelper.elements[i].equals(FactoryHelper.endFlag); i ++) {
			element2ClassName.put(FactoryHelper.elements[i], FactoryHelper.exprClassNames[i]);
		}
	}
	/*
	private static class SingletonHolder {
		private static final ExprFactory EINSTANCE = new ExprFactory();
	}
	
	public static ExprFactory getFactoryInstance() {
		return SingletonHolder.EINSTANCE;
	}
	
	//public AbstractExpr getExprInstance(String elementName) {
	//	return getFactoryInstance().getExpressionInstance(elementName);
	//}
	*/
	public AbstractExpr getExprInstance (String elementName) {
		//AbstractExpr expr = null;
		//getFactoryInstance();
		try {
			String name = element2ClassName.get(elementName);
			if(name != null){
				//Class t = Class.forName(name);
				return (AbstractExpr)Class.forName(name).newInstance();
			}
			
		}catch (Exception e) {
			//expr = new ErrorExpr();
			System.out.println(e);
			return null;
			
		}
		return null;
	}
	
}
