package com.demo.cyj.scroller.test;

import android.test.InstrumentationTestCase;

import com.demo.cyj.scroller.utils.CommUtils;

/**
 * Author: ChenYJ
 * Date: 2016/3/16 10:31
 * Email:cyjchenxiao@163.com
 */
public class ExampleTest extends InstrumentationTestCase{
    private final int excepted = 1;
    private final int reality = 1;
    private final int error = 0;
    public void test() throws Exception{
        assertEquals(excepted, reality);
    }

    public void test_1() throws  Exception{
        if (1>4){
            assertEquals(excepted, reality);
        } else{
            assertEquals(excepted, 1);
        }
    }

    public void test_2() throws Exception{
        int result = CommUtils.sub(4,5);
        if (result == 9){//假设正确逻辑
            assertEquals(excepted, reality);
        } else{//假设错误
            assertEquals(excepted, error);
        }
    }
}
