/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.brukhman.sparser.parser.node;

import org.brukhman.sparser.parser.analysis.*;

@SuppressWarnings("nls")
public final class TLPar extends Token
{
    public TLPar()
    {
        super.setText("(");
    }

    public TLPar(int line, int pos)
    {
        super.setText("(");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TLPar(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTLPar(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TLPar text.");
    }
}
