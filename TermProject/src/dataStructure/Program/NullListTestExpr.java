/**
 * 
 */
package dataStructure.Program;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dataStructure.ATypeFactory;
import dataStructure.ExprFactory;
import dataStructure.Type.AbstractAType;

/**
 * @author Wu Jun A0106507M
 *
 */
public class NullListTestExpr extends AbstractExpr {

	private static final int exprNumC = 1;
	
	public NullListTestExpr() {
		// TODO Auto-generated constructor stub
		init();
	}

	public AbstractExpr getExpr() {
		if(this.exprs.size() == exprNumC) {
			return this.exprs.get(0);
		}else {
			printError();
			return null;
		}
	}

	public void setExpr(AbstractExpr expr) {
		if(this.exprs.size() == exprNumC) {
			this.exprs.set(0, expr);
		}else {
			printError();
		}
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		exprAttribute = new String();
		exprs = new Vector<AbstractExpr>();
		System.out.println(this.toString());
	}

	@Override
	protected String getExprAttribute() {
		// TODO Auto-generated method stub
		System.out.println(this.toString() + " :No attributes!");
		return null;
	}
	/*
	@Override
	protected void setAttributs(List<String> attrList) {
		// TODO Auto-generated method stub
		System.out.println(this.toString() + " :No attributes!");
	}
	*/
	@Override
	public List<AbstractExpr> getAbstractExprsRef() {
		// TODO Auto-generated method stub
		return this.exprs;
	}
/*
	@Override
	protected void setAbstractExprs(List<AbstractExpr> aExprs) {
		// TODO Auto-generated method stub
		if(this.exprs.size() == exprNum_c) {
			this.exprs = aExprs;
		}else {
			printError();
		}
	}
*/
	@Override
	protected void printError() {
		// TODO Auto-generated method stub
		System.err.println(this.toString() + " :Expression num should be " + exprNumC);
	}

	@Override
	public void populateExpr(Node xmlNode, ExprFactory builder) {
		// TODO Auto-generated method stub
		Node entryNode = xmlNode.getFirstChild();
		while(entryNode != null) {
			NodeList nLst = entryNode.getChildNodes();
			for(int i = 0; i < nLst.getLength(); i ++) {
				AbstractExpr newExpr = builder.getExprInstance(nLst.item(i).getNodeName());
				if(newExpr != null) {
					this.exprs.add(newExpr);
					this.exprs.get(exprs.size() - 1).populateExpr(nLst.item(i), builder);
				}
			}
			entryNode = entryNode.getNextSibling();
		}
	}
}
