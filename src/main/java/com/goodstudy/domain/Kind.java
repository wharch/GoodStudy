package com.goodstudy.domain;
/*
* 孙向锋
* */
public class Kind {
    private int kindId;
    private String kindName;
    //空构造
    public Kind() {
    }
    //有参构造

    public Kind(int kindId, String kindName) {
        this.kindId = kindId;
        this.kindName = kindName;
    }

    public Kind(String kindName) {
        this.kindName = kindName;
    }

    //toString方法

    @Override
    public String toString() {
        return "Kind{" +
                "kindId=" + kindId +
                ", kindName='" + kindName + '\'' +
                '}';
    }


    //get和set方法


    public int getKindId() {
        return kindId;
    }

    public void setKindId(int kindId) {
        this.kindId = kindId;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }
}
