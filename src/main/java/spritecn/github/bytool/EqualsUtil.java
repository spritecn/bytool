package spritecn.github.bytool;

import java.util.Objects;

public class EqualsUtil {
    public boolean equals(Object obj1,Object obj2){
        return Objects.equals(obj1,obj2);
    }

    public boolean notEquals(Object obj1,Object obj2){
        return !Objects.equals(obj1,obj2);
    }


    public boolean allEquals(Object ...objs){
        if(Objects.isNull(objs)) return false;
        if(ArgsUtil.anyNull(objs)) return false;
        if(objs.length < 2) return false;
        Object obj1 = objs[0];
        for (Object obj : objs) {
            if(notEquals(obj1,obj)) return false;
        }
        return true;
    }


}
