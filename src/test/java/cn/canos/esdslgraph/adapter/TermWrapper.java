package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.Term;

public class TermWrapper {
    private Term term;

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }
}