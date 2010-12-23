package org.brukhman.sparser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;

import org.brukhman.sparser.language.analysis.DepthFirstAdapter;
import org.brukhman.sparser.language.node.ADivExp;
import org.brukhman.sparser.language.node.AGrammar;
import org.brukhman.sparser.language.node.AMinusExp;
import org.brukhman.sparser.language.node.AMultExp;
import org.brukhman.sparser.language.node.ANumberExp;
import org.brukhman.sparser.language.node.APlusExp;
import org.brukhman.sparser.language.node.ARandomX2Exp;
import org.brukhman.sparser.language.node.AT1Textual;
import org.brukhman.sparser.language.node.AT2Textual;
import org.brukhman.sparser.language.node.AT3Textual;
import org.brukhman.sparser.language.node.ATextualExp;
import org.brukhman.sparser.language.node.Node;
import org.brukhman.sparser.language.node.PExp;
import org.brukhman.sparser.language.node.PTextual;


/**
 * Visitor.
 * 
 * @author jbrukh
 *
 */
public class Calculate extends DepthFirstAdapter {

	// FIELDS //
	
	private Map<Node,Integer> node2int = new HashMap<Node, Integer> ();
	private Random rnd = new Random ();

	
	/**
	 * Get the integer value of a node.
	 * 
	 * @param node
	 * @return
	 */
	private int getNodeInt (Node node) {
		return node2int.get(node);
	}

	/**
	 * Set the integer value of a node.
	 */
	private void setNodeInt (Node node, int val) {
		node2int.put (node, val);
	}

	
	public void outAGrammar (AGrammar node) {
		Iterator<PExp> it = node.getExp().iterator();
		while (it.hasNext())
		{
			PExp exp = it.next();
			System.out.print (getNodeInt (exp));
			if ( it.hasNext() ) System.out.print ("; ");
		}
		System.out.println ();
	}

	public void outANumberExp (ANumberExp node) {
		setNodeInt (node, Integer.parseInt (node.getNumber().getText()));
	}

	public void outAPlusExp (APlusExp node)
	{
		setNodeInt (node, getNodeInt (node.getL()) + getNodeInt (node.getR()));
	}

	public void outAMinusExp (AMinusExp node)
	{
		setNodeInt (node, getNodeInt (node.getL()) - getNodeInt (node.getR()));
	}

	public void outAMultExp (AMultExp node)
	{
		setNodeInt (node, getNodeInt (node.getL()) * getNodeInt (node.getR()));
	}

	public void outADivExp (ADivExp node) {
		// maybe we should check here for division by zero? :)
		setNodeInt (node, getNodeInt (node.getL()) / getNodeInt (node.getR()));
	}

	public void outAT1Textual (AT1Textual node) {
		setNodeInt (node, 1);
	}

	public void outAT2Textual (AT2Textual node) {
		setNodeInt (node, 2);
	}

	public void outAT3Textual (AT3Textual node) {
		setNodeInt (node, 3);
	}

	public void outATextualExp (ATextualExp node)
	{
		int res = 0;
		int mul = 1;
		ListIterator<PTextual> it = node.getTextual().listIterator (node.getTextual().size());
		while ( it.hasPrevious () )
		{
			PTextual t = it.previous();
			res += mul * getNodeInt (t);
			mul *= 10;
		}
		setNodeInt (node, res);
	}

	public void outARandomX2Exp (ARandomX2Exp node) {
		setNodeInt (node, rnd.nextInt(100));
	}
}


