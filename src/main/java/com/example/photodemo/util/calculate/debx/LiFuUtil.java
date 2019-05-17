package com.example.photodemo.util.calculate.debx;

/**
 * @author zmt
 * @date 2019-04-29 17:20
 */
public class LiFuUtil extends DebxUtil implements DebxBuilder {

    @Override
    public void eat() {
        System.out.println("礼服-子类吃东西");
    }

    @Override
    public void getResultMap() {
        eat();
    }
}
