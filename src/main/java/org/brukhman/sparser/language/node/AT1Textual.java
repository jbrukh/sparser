/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.brukhman.sparser.language.node;

import org.brukhman.sparser.language.analysis.*;

@SuppressWarnings("nls")
public final class AT1Textual extends PTextual
{
    private TOne _one_;

    public AT1Textual()
    {
        // Constructor
    }

    public AT1Textual(
        @SuppressWarnings("hiding") TOne _one_)
    {
        // Constructor
        setOne(_one_);

    }

    @Override
    public Object clone()
    {
        return new AT1Textual(
            cloneNode(this._one_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAT1Textual(this);
    }

    public TOne getOne()
    {
        return this._one_;
    }

    public void setOne(TOne node)
    {
        if(this._one_ != null)
        {
            this._one_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._one_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._one_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._one_ == child)
        {
            this._one_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._one_ == oldChild)
        {
            setOne((TOne) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
