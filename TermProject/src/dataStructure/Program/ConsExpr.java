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
public class ConsExpr extends AbstractExpr {

	private static final int exprNumC = 2;
		
	public ConsExpr() {
		// TODO Auto-generated constructor stub
		init();
	}

	public AbstractExpr getHeadExpr() {
		if(exprs.size() == exprNumC) {
			return exprs.get(0);
		}else {
			printError();
			return null;
		}

	}

	public void setHeadExpr(AbstractExpr headExpr) {
		if(exprs.size() == exprNumC) {
			exprs.set(0, headExpr);
		}else {
			printError();
		}
	}

	public AbstractExpr getTailExpr() {
		if(exprs.size() == exprNumC) {
			return exprs.get(1);
		}else {
			printError();
			return null;
		}
	}

	public void setTailExpr(AbstractExpr tailExpr) {
		if(exprs.size() == exprNumC) {
			exprs.set(1, tailExpr);
		}else {
			printError();
		}
	}

	@Override
	protected void init() {
		exprAttribute = new String();
		exprs = new Vector<AbstractExpr>();
		System.out.println(this.toString());
	}

	@Override
	protected String getExprAttribute() {
		// TODO Auto-generated method stub
		System.out.println(this.toString() + " :No Attributes!");
		return null;
	}
	/*
	@Override
	protected void setAttributs(List<String> attrList) {
		// TODO Auto-generated method stub
		System.out.println(this.toString() + " :No Attributes!");
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
		if(exprs.size() == exprNum_c) {
			this.exprs = aExprs;
		}else {
			printError();
		}
	}
	*/
	@Override
	protected void printError() {
		// TODO Auto-generated method stub
		System.err.println(this.toString() + " :Exression num should be " + exprNumC);
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