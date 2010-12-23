package org.brukhman.sparser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PushbackReader;

import org.brukhman.sparser.language.lexer.Lexer;
import org.brukhman.sparser.language.node.Start;
import org.brukhman.sparser.language.parser.Parser;
/**
 * The main class to run the Simple Parser.
 * 
 * @author jbrukh
 *
 */
public class Main {

	/**
	 * Main method.
	 * 
	 * @param argv
	 */
	public static void main ( String[] argv ) {
		
		try {
			Lexer l = new Lexer(new PushbackReader (new BufferedReader(new InputStreamReader (System.in))));
			Parser p = new Parser(l);
			Start start = p.parse ();
			System.out.println (start.toString());

			Calculate calculator = new Calculate ();
			start.apply (calculator);

			//ASTDisplay ad = new ASTDisplay ();
			//start.apply (ad);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
};

