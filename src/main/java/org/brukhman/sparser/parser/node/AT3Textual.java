/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.brukhman.sparser.parser.node;

import org.brukhman.sparser.parser.analysis.*;

@SuppressWarnings("nls")
public final class AT3Textual extends PTextual
{
    private TThree _three_;

    public AT3Textual()
    {
        // Constructor
    }

    public AT3Textual(
        @SuppressWarnings("hiding") TThree _three_)
    {
        // Constructor
        setThree(_three_);

    }

    @Override
    public Object clone()
    {
        return new AT3Textual(
            cloneNode(this._three_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAT3Textual(this);
    }

    public TThree getThree()
    {
        return this._three_;
    }

    public void setThree(TThree node)
    {
        if(this._three_ != null)
        {
            this._three_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._three_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._three_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._three_ == child)
        {
            this._three_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._three_ == oldChild)
        {
            setThree((TThree) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
