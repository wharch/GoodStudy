package com.goodstudy.domain;
/*
* 孙向锋
* */
public class Kind {
    private int kind_id;
    private String king_name;
    //空构造
    public Kind() {
    }
    //有参构造

    public Kind(int kind_id, String king_name) {
        this.kind_id = kind_id;
        this.king_name = king_name;
    }
    //toString方法

    @Override
    public String toString() {
        return "Kind{" +
                "kind_id=" + kind_id +
                ", king_name='" + king_name + '\'' +
                '}';
    }
    //get和set方法

    public int getKind_id() {
        return kind_id;
    }

    public void setKind_id(int kind_id) {
        this.kind_id = kind_id;
    }

    public String getKing_name() {
        return king_name;
    }

    public void setKing_name(String king_name) {
        this.king_name = king_name;
    }
}
