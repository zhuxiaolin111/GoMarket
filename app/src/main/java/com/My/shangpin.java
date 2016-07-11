package com.My;

import java.io.Serializable;

/**
 * Created by mn on 2016/7/10.
 */
public class shangpin implements Serializable {

    private int pic;
    private String name;
    private int price;

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
