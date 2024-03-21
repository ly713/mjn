package com.MJN.demo;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuestionOneTest {
    @Test
    void questionOne(){
        Fruit apple = new Fruit(Constant.PRICE_OF_APPLE,Constant.CODE_OF_APPLE);
        Fruit strawberry = new Fruit(Constant.PRICE_OF_STRAWBERRY,Constant.CODE_OF_STRAWBERRY);
        int sumApple = calPrice(2,apple.getCode());
        int sumStrawberry = calPrice(1,strawberry.getCode());
        int total = sumApple+sumStrawberry;
        System.out.println("您购买的水果总价为："+total);
    }

    public int calPrice(int kilogram, String fruitCode){
        if (kilogram<0){
            throw new RuntimeException("重量错误， 请重新输入.");
        }
        if (StringUtils.isNotBlank(fruitCode)){
            if (fruitCode.equals(Constant.CODE_OF_STRAWBERRY)){
                return kilogram*Constant.PRICE_OF_STRAWBERRY;
            } else if (fruitCode.equals(Constant.CODE_OF_APPLE)) {
                return kilogram*Constant.PRICE_OF_APPLE;
            }else {
                throw new RuntimeException("水果代码错误。");
            }
        } else{
            throw new RuntimeException("水果代码错误。");
        }
    }

}
