package spritecn.github.bytool;

import java.math.BigDecimal;
import java.util.Objects;

public class BigDecimalUtil {
    //a>b
    boolean  greaterThan(BigDecimal a,BigDecimal b){
        if(ArgsUtil.anyNull(a,b)) return false;
        return a.compareTo(b) > 0;
    }

    //a < b
    boolean  lessThan(BigDecimal a,BigDecimal b){
        if(ArgsUtil.anyNull(a,b)) return false;
        return a.compareTo(b) < 0;
    }

    //a>=b
    boolean  greaterOrEquals(BigDecimal a,BigDecimal b){
        if(ArgsUtil.anyNull(a,b)) return false;
        return a.compareTo(b) > -1;
    }

    //a <= b
    boolean  lessOrEquals(BigDecimal a,BigDecimal b){
        if(ArgsUtil.anyNull(a,b)) return false;
        return a.compareTo(b) < 1;
    }

    //四舍五入
    BigDecimal round(BigDecimal decimal,int scala){
        if(Objects.isNull(decimal)) return null;
        return decimal.setScale(scala,BigDecimal.ROUND_HALF_UP);
    }


}
