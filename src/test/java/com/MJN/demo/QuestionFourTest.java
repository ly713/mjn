package com.MJN.demo;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import static com.MJN.demo.Constant.DISCOUNT_OF_STRAWBERRY;

@SpringBootTest
class QuestionFourTest {

    @Test
    void questionOne(){
        Fruit apple = new Fruit(Constant.PRICE_OF_APPLE,Constant.CODE_OF_APPLE);
        Fruit strawberry = new Fruit(Constant.PRICE_OF_STRAWBERRY,Constant.CODE_OF_STRAWBERRY);
        Fruit mango = new Fruit(Constant.PRICE_OF_MANGO,Constant.CODE_OF_MANGO);
        double sumApple = calPrice(0,apple.getCode());
        double sumStrawberry = calPrice(0,strawberry.getCode());
        double sumMango = calPrice(21,mango.getCode());
        double total = sumApple+sumStrawberry+sumMango;
        System.out.println("您购买的水果原价为："+total);
        int totalDiscount = (int)total/100;
        total -= totalDiscount*10;
        System.out.println("商店现有优惠满100-10， 你本次的消费金额可以参与："+totalDiscount+"次");
        System.out.println("您购买的水果折后为："+total);
    }

    public double calPrice(int kilogram, String fruitCode){
        if (kilogram<0){
            throw new RuntimeException("重量错误， 请重新输入.");
        }
        if (StringUtils.isNotBlank(fruitCode)){
            if (fruitCode.equals(Constant.CODE_OF_STRAWBERRY)){
                return kilogram*Constant.PRICE_OF_STRAWBERRY*DISCOUNT_OF_STRAWBERRY;
            } else if (fruitCode.equals(Constant.CODE_OF_APPLE)) {
                return kilogram*Constant.PRICE_OF_APPLE;
            } else if (fruitCode.equals(Constant.CODE_OF_MANGO)) {
                return kilogram*Constant.PRICE_OF_MANGO;
            } else {
                throw new RuntimeException("水果代码错误。");
            }
        } else{
            throw new RuntimeException("水果代码错误。");
        }
    }

}
