import com.itheima01.annotation.Entity;
import com.itheima01.pojo.Student;

import java.lang.reflect.Field;

/**
 * @author codermao
 * @date 2023/2/20 10:14
 */
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("com.itheima01.pojo.Student");
        Student stu = (Student) clazz.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            boolean flag = field.isAnnotationPresent(Entity.class);
            if (flag){
                Entity anno = field.getAnnotation(Entity.class);
                field.setAccessible(true);
                if (field.getName().equals("age")){
                    field.set(stu,Integer.parseInt(anno.value()));
                }else {
                field.set(stu,anno.value());
                }
            }
        }

        System.out.println(stu);
    }
}
