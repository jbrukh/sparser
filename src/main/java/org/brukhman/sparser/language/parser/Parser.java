/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.brukhman.sparser.language.parser;

import org.brukhman.sparser.language.lexer.*;
import org.brukhman.sparser.language.node.*;
import org.brukhman.sparser.language.analysis.*;
import java.util.*;

import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;

@SuppressWarnings("nls")
public class Parser
{
    public final Analysis ignoredTokens = new AnalysisAdapter();

    protected ArrayList nodeList;

    private final Lexer lexer;
    private final ListIterator stack = new LinkedList().listIterator();
    private int last_pos;
    private int last_line;
    private Token last_token;
    private final TokenIndex converter = new TokenIndex();
    private final int[] action = new int[2];

    private final static int SHIFT = 0;
    private final static int REDUCE = 1;
    private final static int ACCEPT = 2;
    private final static int ERROR = 3;

    public Parser(@SuppressWarnings("hiding") Lexer lexer)
    {
        this.lexer = lexer;
    }

    @SuppressWarnings({"unchecked","unused"})
    private void push(int numstate, ArrayList listNode) throws ParserException, LexerException, IOException
    {
        this.nodeList = listNode;

        if(!this.stack.hasNext())
        {
            this.stack.add(new State(numstate, this.nodeList));
            return;
        }

        State s = (State) this.stack.next();
        s.state = numstate;
        s.nodes = this.nodeList;
    }

    private int goTo(int index)
    {
        int state = state();
        int low = 1;
        int high = gotoTable[index].length - 1;
        int value = gotoTable[index][0][1];

        while(low <= high)
        {
            int middle = (low + high) / 2;

            if(state < gotoTable[index][middle][0])
            {
                high = middle - 1;
            }
            else if(state > gotoTable[index][middle][0])
            {
                low = middle + 1;
            }
            else
            {
                value = gotoTable[index][middle][1];
                break;
            }
        }

        return value;
    }

    private int state()
    {
        State s = (State) this.stack.previous();
        this.stack.next();
        return s.state;
    }

    private ArrayList pop()
    {
        return ((State) this.stack.previous()).nodes;
    }

    private int index(Switchable token)
    {
        this.converter.index = -1;
        token.apply(this.converter);
        return this.converter.index;
    }

    @SuppressWarnings("unchecked")
    public Start parse() throws ParserException, LexerException, IOException
    {
        push(0, null);
        List<Node> ign = null;
        while(true)
        {
            while(index(this.lexer.peek()) == -1)
            {
                if(ign == null)
                {
                    ign = new LinkedList<Node>();
                }

                ign.add(this.lexer.next());
            }

            if(ign != null)
            {
                this.ignoredTokens.setIn(this.lexer.peek(), ign);
                ign = null;
            }

            this.last_pos = this.lexer.peek().getPos();
            this.last_line = this.lexer.peek().getLine();
            this.last_token = this.lexer.peek();

            int index = index(this.lexer.peek());
            this.action[0] = Parser.actionTable[state()][0][1];
            this.action[1] = Parser.actionTable[state()][0][2];

            int low = 1;
            int high = Parser.actionTable[state()].length - 1;

            while(low <= high)
            {
                int middle = (low + high) / 2;

                if(index < Parser.actionTable[state()][middle][0])
                {
                    high = middle - 1;
                }
                else if(index > Parser.actionTable[state()][middle][0])
                {
                    low = middle + 1;
                }
                else
                {
                    this.action[0] = Parser.actionTable[state()][middle][1];
                    this.action[1] = Parser.actionTable[state()][middle][2];
                    break;
                }
            }

            switch(this.action[0])
            {
                case SHIFT:
		    {
		        ArrayList list = new ArrayList();
		        list.add(this.lexer.next());
                        push(this.action[1], list);
                    }
		    break;
                case REDUCE:
                    switch(this.action[1])
                    {
                    case 0: /* reduce AGrammar */
		    {
			ArrayList list = new0();
			push(goTo(0), list);
		    }
		    break;
                    case 1: /* reduce AListExpList */
		    {
			ArrayList list = new1();
			push(goTo(1), list);
		    }
		    break;
                    case 2: /* reduce ASingleExpList */
		    {
			ArrayList list = new2();
			push(goTo(1), list);
		    }
		    break;
                    case 3: /* reduce APlusExp */
		    {
			ArrayList list = new3();
			push(goTo(2), list);
		    }
		    break;
                    case 4: /* reduce AMinusExp */
		    {
			ArrayList list = new4();
			push(goTo(2), list);
		    }
		    break;
                    case 5: /* reduce AFactorExp */
		    {
			ArrayList list = new5();
			push(goTo(2), list);
		    }
		    break;
                    case 6: /* reduce AMultFactor */
		    {
			ArrayList list = new6();
			push(goTo(3), list);
		    }
		    break;
                    case 7: /* reduce ADivFactor */
		    {
			ArrayList list = new7();
			push(goTo(3), list);
		    }
		    break;
                    case 8: /* reduce ATermFactor */
		    {
			ArrayList list = new8();
			push(goTo(3), list);
		    }
		    break;
                    case 9: /* reduce ANumberTerm */
		    {
			ArrayList list = new9();
			push(goTo(4), list);
		    }
		    break;
                    case 10: /* reduce AExpTerm */
		    {
			ArrayList list = new10();
			push(goTo(4), list);
		    }
		    break;
                    case 11: /* reduce ATextualTerm */
		    {
			ArrayList list = new11();
			push(goTo(4), list);
		    }
		    break;
                    case 12: /* reduce ARandomX2Term */
		    {
			ArrayList list = new12();
			push(goTo(4), list);
		    }
		    break;
                    case 13: /* reduce AT1Textual */
		    {
			ArrayList list = new13();
			push(goTo(5), list);
		    }
		    break;
                    case 14: /* reduce AT2Textual */
		    {
			ArrayList list = new14();
			push(goTo(5), list);
		    }
		    break;
                    case 15: /* reduce AT3Textual */
		    {
			ArrayList list = new15();
			push(goTo(5), list);
		    }
		    break;
                    case 16: /* reduce ARandomX2 */
		    {
			ArrayList list = new16();
			push(goTo(6), list);
		    }
		    break;
                    case 17: /* reduce ASemicolonSeparator */
		    {
			ArrayList list = new17();
			push(goTo(7), list);
		    }
		    break;
                    case 18: /* reduce ATerminal$Textual */
		    {
			ArrayList list = new18();
			push(goTo(8), list);
		    }
		    break;
                    case 19: /* reduce ANonTerminal$Textual */
		    {
			ArrayList list = new19();
			push(goTo(8), list);
		    }
		    break;
                    }
                    break;
                case ACCEPT:
                    {
                        EOF node2 = (EOF) this.lexer.next();
                        PGrammar node1 = (PGrammar) pop().get(0);
                        Start node = new Start(node1, node2);
                        return node;
                    }
                case ERROR:
                    throw new ParserException(this.last_token,
                        "[" + this.last_line + "," + this.last_pos + "] " +
                        Parser.errorMessages[Parser.errors[this.action[1]]]);
            }
        }
    }



    @SuppressWarnings("unchecked")
    ArrayList new0() /* reduce AGrammar */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PGrammar pgrammarNode1;
        {
            // Block
        LinkedList listNode3 = new LinkedList();
        {
            // Block
        LinkedList listNode2 = new LinkedList();
        listNode2 = (LinkedList)nodeArrayList1.get(0);
	if(listNode2 != null)
	{
	  listNode3.addAll(listNode2);
	}
        }

        pgrammarNode1 = new AGrammar(listNode3);
        }
	nodeList.add(pgrammarNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new1() /* reduce AListExpList */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        LinkedList listNode3 = new LinkedList();
        {
            // Block
        LinkedList listNode1 = new LinkedList();
        PExp pexpNode2;
        listNode1 = (LinkedList)nodeArrayList1.get(0);
        pexpNode2 = (PExp)nodeArrayList3.get(0);
	if(listNode1 != null)
	{
	  listNode3.addAll(listNode1);
	}
	if(pexpNode2 != null)
	{
	  listNode3.add(pexpNode2);
	}
        }
	nodeList.add(listNode3);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new2() /* reduce ASingleExpList */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        LinkedList listNode2 = new LinkedList();
        {
            // Block
        PExp pexpNode1;
        pexpNode1 = (PExp)nodeArrayList1.get(0);
	if(pexpNode1 != null)
	{
	  listNode2.add(pexpNode1);
	}
        }
	nodeList.add(listNode2);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new3() /* reduce APlusExp */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PExp pexpNode1;
        {
            // Block
        PExp pexpNode2;
        PExp pexpNode3;
        pexpNode2 = (PExp)nodeArrayList1.get(0);
        pexpNode3 = (PExp)nodeArrayList3.get(0);

        pexpNode1 = new APlusExp(pexpNode2, pexpNode3);
        }
	nodeList.add(pexpNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new4() /* reduce AMinusExp */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PExp pexpNode1;
        {
            // Block
        PExp pexpNode2;
        PExp pexpNode3;
        pexpNode2 = (PExp)nodeArrayList1.get(0);
        pexpNode3 = (PExp)nodeArrayList3.get(0);

        pexpNode1 = new AMinusExp(pexpNode2, pexpNode3);
        }
	nodeList.add(pexpNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new5() /* reduce AFactorExp */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PExp pexpNode1;
        pexpNode1 = (PExp)nodeArrayList1.get(0);
	nodeList.add(pexpNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new6() /* reduce AMultFactor */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PExp pexpNode1;
        {
            // Block
        PExp pexpNode2;
        PExp pexpNode3;
        pexpNode2 = (PExp)nodeArrayList1.get(0);
        pexpNode3 = (PExp)nodeArrayList3.get(0);

        pexpNode1 = new AMultExp(pexpNode2, pexpNode3);
        }
	nodeList.add(pexpNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new7() /* reduce ADivFactor */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PExp pexpNode1;
        {
            // Block
        PExp pexpNode2;
        PExp pexpNode3;
        pexpNode2 = (PExp)nodeArrayList1.get(0);
        pexpNode3 = (PExp)nodeArrayList3.get(0);

        pexpNode1 = new ADivExp(pexpNode2, pexpNode3);
        }
	nodeList.add(pexpNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new8() /* reduce ATermFactor */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PExp pexpNode1;
        pexpNode1 = (PExp)nodeArrayList1.get(0);
	nodeList.add(pexpNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new9() /* reduce ANumberTerm */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PExp pexpNode1;
        {
            // Block
        TNumber tnumberNode2;
        tnumberNode2 = (TNumber)nodeArrayList1.get(0);

        pexpNode1 = new ANumberExp(tnumberNode2);
        }
	nodeList.add(pexpNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new10() /* reduce AExpTerm */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PExp pexpNode1;
        pexpNode1 = (PExp)nodeArrayList2.get(0);
	nodeList.add(pexpNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new11() /* reduce ATextualTerm */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PExp pexpNode1;
        {
            // Block
        LinkedList listNode3 = new LinkedList();
        {
            // Block
        LinkedList listNode2 = new LinkedList();
        listNode2 = (LinkedList)nodeArrayList1.get(0);
	if(listNode2 != null)
	{
	  listNode3.addAll(listNode2);
	}
        }

        pexpNode1 = new ATextualExp(listNode3);
        }
	nodeList.add(pexpNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new12() /* reduce ARandomX2Term */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PExp pexpNode1;
        {
            // Block
        TRandom trandomNode2;
        TRandom trandomNode3;
        trandomNode2 = (TRandom)nodeArrayList1.get(0);
        trandomNode3 = (TRandom)nodeArrayList1.get(1);

        pexpNode1 = new ARandomX2Exp(trandomNode2, trandomNode3);
        }
	nodeList.add(pexpNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new13() /* reduce AT1Textual */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PTextual ptextualNode1;
        {
            // Block
        TOne toneNode2;
        toneNode2 = (TOne)nodeArrayList1.get(0);

        ptextualNode1 = new AT1Textual(toneNode2);
        }
	nodeList.add(ptextualNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new14() /* reduce AT2Textual */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PTextual ptextualNode1;
        {
            // Block
        TTwo ttwoNode2;
        ttwoNode2 = (TTwo)nodeArrayList1.get(0);

        ptextualNode1 = new AT2Textual(ttwoNode2);
        }
	nodeList.add(ptextualNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new15() /* reduce AT3Textual */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PTextual ptextualNode1;
        {
            // Block
        TThree tthreeNode2;
        tthreeNode2 = (TThree)nodeArrayList1.get(0);

        ptextualNode1 = new AT3Textual(tthreeNode2);
        }
	nodeList.add(ptextualNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new16() /* reduce ARandomX2 */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        TRandom trandomNode1;
        TRandom trandomNode2;
        trandomNode1 = (TRandom)nodeArrayList1.get(0);
        trandomNode2 = (TRandom)nodeArrayList2.get(0);
	nodeList.add(trandomNode1);
	nodeList.add(trandomNode2);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new17() /* reduce ASemicolonSeparator */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new18() /* reduce ATerminal$Textual */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        LinkedList listNode2 = new LinkedList();
        {
            // Block
        PTextual ptextualNode1;
        ptextualNode1 = (PTextual)nodeArrayList1.get(0);
	if(ptextualNode1 != null)
	{
	  listNode2.add(ptextualNode1);
	}
        }
	nodeList.add(listNode2);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new19() /* reduce ANonTerminal$Textual */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        LinkedList listNode3 = new LinkedList();
        {
            // Block
        LinkedList listNode1 = new LinkedList();
        PTextual ptextualNode2;
        listNode1 = (LinkedList)nodeArrayList1.get(0);
        ptextualNode2 = (PTextual)nodeArrayList2.get(0);
	if(listNode1 != null)
	{
	  listNode3.addAll(listNode1);
	}
	if(ptextualNode2 != null)
	{
	  listNode3.add(ptextualNode2);
	}
        }
	nodeList.add(listNode3);
        return nodeList;
    }



    private static int[][][] actionTable;
/*      {
			{{-1, ERROR, 0}, {0, SHIFT, 1}, {7, SHIFT, 2}, {8, SHIFT, 3}, {9, SHIFT, 4}, {10, SHIFT, 5}, {11, SHIFT, 6}, },
			{{-1, ERROR, 1}, {0, SHIFT, 1}, {7, SHIFT, 2}, {8, SHIFT, 3}, {9, SHIFT, 4}, {10, SHIFT, 5}, {11, SHIFT, 6}, },
			{{-1, REDUCE, 9}, },
			{{-1, REDUCE, 13}, },
			{{-1, REDUCE, 14}, },
			{{-1, REDUCE, 15}, },
			{{-1, ERROR, 6}, {11, SHIFT, 16}, },
			{{-1, ERROR, 7}, {12, ACCEPT, -1}, },
			{{-1, REDUCE, 0}, {6, SHIFT, 17}, },
			{{-1, REDUCE, 2}, {2, SHIFT, 19}, {3, SHIFT, 20}, },
			{{-1, REDUCE, 5}, {4, SHIFT, 21}, {5, SHIFT, 22}, },
			{{-1, REDUCE, 8}, },
			{{-1, REDUCE, 18}, },
			{{-1, REDUCE, 12}, },
			{{-1, REDUCE, 11}, {8, SHIFT, 3}, {9, SHIFT, 4}, {10, SHIFT, 5}, },
			{{-1, ERROR, 15}, {1, SHIFT, 24}, {2, SHIFT, 19}, {3, SHIFT, 20}, },
			{{-1, REDUCE, 16}, },
			{{-1, REDUCE, 17}, },
			{{-1, ERROR, 18}, {0, SHIFT, 1}, {7, SHIFT, 2}, {8, SHIFT, 3}, {9, SHIFT, 4}, {10, SHIFT, 5}, {11, SHIFT, 6}, },
			{{-1, ERROR, 19}, {0, SHIFT, 1}, {7, SHIFT, 2}, {8, SHIFT, 3}, {9, SHIFT, 4}, {10, SHIFT, 5}, {11, SHIFT, 6}, },
			{{-1, ERROR, 20}, {0, SHIFT, 1}, {7, SHIFT, 2}, {8, SHIFT, 3}, {9, SHIFT, 4}, {10, SHIFT, 5}, {11, SHIFT, 6}, },
			{{-1, ERROR, 21}, {0, SHIFT, 1}, {7, SHIFT, 2}, {8, SHIFT, 3}, {9, SHIFT, 4}, {10, SHIFT, 5}, {11, SHIFT, 6}, },
			{{-1, ERROR, 22}, {0, SHIFT, 1}, {7, SHIFT, 2}, {8, SHIFT, 3}, {9, SHIFT, 4}, {10, SHIFT, 5}, {11, SHIFT, 6}, },
			{{-1, REDUCE, 19}, },
			{{-1, REDUCE, 10}, },
			{{-1, REDUCE, 1}, {2, SHIFT, 19}, {3, SHIFT, 20}, },
			{{-1, REDUCE, 3}, {4, SHIFT, 21}, {5, SHIFT, 22}, },
			{{-1, REDUCE, 4}, {4, SHIFT, 21}, {5, SHIFT, 22}, },
			{{-1, REDUCE, 6}, },
			{{-1, REDUCE, 7}, },
        };*/
    private static int[][][] gotoTable;
/*      {
			{{-1, 7}, },
			{{-1, 8}, },
			{{-1, 9}, {1, 15}, {18, 25}, },
			{{-1, 10}, {19, 26}, {20, 27}, },
			{{-1, 11}, {21, 28}, {22, 29}, },
			{{-1, 12}, {14, 23}, },
			{{-1, 13}, },
			{{-1, 18}, },
			{{-1, 14}, },
        };*/
    private static String[] errorMessages;
/*      {
			"expecting: '(', number, 'one', 'two', 'three', 'random_digit'",
			"expecting: ')', '+', '-', '*', '/', ';', EOF",
			"expecting: ')', '+', '-', '*', '/', ';', 'one', 'two', 'three', EOF",
			"expecting: 'random_digit'",
			"expecting: EOF",
			"expecting: ';', EOF",
			"expecting: '+', '-', ';', EOF",
			"expecting: ')', '+', '-'",
        };*/
    private static int[] errors;
/*      {
			0, 0, 1, 2, 2, 2, 3, 4, 5, 6, 1, 1, 2, 1, 2, 7, 1, 0, 0, 0, 0, 0, 0, 2, 1, 6, 1, 1, 1, 1, 
        };*/

    static 
    {
        try
        {
            DataInputStream s = new DataInputStream(
                new BufferedInputStream(
                Parser.class.getResourceAsStream("parser.dat")));

            // read actionTable
            int length = s.readInt();
            Parser.actionTable = new int[length][][];
            for(int i = 0; i < Parser.actionTable.length; i++)
            {
                length = s.readInt();
                Parser.actionTable[i] = new int[length][3];
                for(int j = 0; j < Parser.actionTable[i].length; j++)
                {
                for(int k = 0; k < 3; k++)
                {
                    Parser.actionTable[i][j][k] = s.readInt();
                }
                }
            }

            // read gotoTable
            length = s.readInt();
            gotoTable = new int[length][][];
            for(int i = 0; i < gotoTable.length; i++)
            {
                length = s.readInt();
                gotoTable[i] = new int[length][2];
                for(int j = 0; j < gotoTable[i].length; j++)
                {
                for(int k = 0; k < 2; k++)
                {
                    gotoTable[i][j][k] = s.readInt();
                }
                }
            }

            // read errorMessages
            length = s.readInt();
            errorMessages = new String[length];
            for(int i = 0; i < errorMessages.length; i++)
            {
                length = s.readInt();
                StringBuffer buffer = new StringBuffer();

                for(int j = 0; j < length; j++)
                {
                buffer.append(s.readChar());
                }
                errorMessages[i] = buffer.toString();
            }

            // read errors
            length = s.readInt();
            errors = new int[length];
            for(int i = 0; i < errors.length; i++)
            {
                errors[i] = s.readInt();
            }

            s.close();
        }
        catch(Exception e)
        {
            throw new RuntimeException("The file \"parser.dat\" is either missing or corrupted.");
        }
    }
}
