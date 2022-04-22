package spritecn.github.bytool;

import java.util.Objects;

public class ArgsUtil {

    //任意一个为null
    public static boolean anyNull(Object ...objects){
        if(Objects.isNull(objects)) return true;
        for (Object object : objects) {
            if(Objects.isNull(object)) return true;
        }
        return false;
    }

    //全部不为null
    public static boolean notNull(Object ...objects){
        return !anyNull(objects);
    }

    //任意元素为空
    @SuppressWarnings("rawtypes")
    public static boolean anyEmpty(Iterable...iterables){
        if(Objects.isNull(iterables)) return true;
        for (Iterable item : iterables) {
            if(Objects.isNull(item)) return true;
            if(!item.iterator().hasNext()) return true;
        }
        return false;
    }

    //任意元素为null以及迭代对象或数组为空
    @SuppressWarnings("rawtypes")
    public static boolean anyNullOrEmpty(Object...objects){
        if(Objects.isNull(objects)) return true;
        for (Object obj : objects) {
            if(Objects.isNull(obj)) return true;
            if(obj instanceof Iterable){
                return iterableIsEmpty((Iterable) obj);
            }
            if(obj.getClass().isArray()){
                return arrayIsEmpty((Object[]) obj);
            }
            if(obj instanceof String){
                return ((String) obj).isEmpty();
            }
        }
        return false;
    }

    @SafeVarargs
    public static <T> T getFirstNotNull(T...objects){
        if(Objects.isNull(objects)) return null;
        for (T obj : objects) {
            if(Objects.nonNull(obj)) return obj;
        }
        return null;
    }


    @SuppressWarnings("rawtypes")
    private static boolean iterableIsEmpty(Iterable iterable){
        if(Objects.isNull(iterable)) return true;
        if(!iterable.iterator().hasNext()){
            return true;
        }
        return false;
    }


    private static boolean arrayIsEmpty(Object[] array){
        if(Objects.isNull(array)) return true;
        if(array.length == 0){
            return true;
        }
        return false;
    }

}
