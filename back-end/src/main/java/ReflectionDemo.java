import java.lang.reflect.Field;

@Myannotation
public class ReflectionDemo {

  @Deprecated
  @Myannotation
  public int a;
  public int b;

  @Myannotation
  public static void main(String[] args) {
    Field[] fields = ReflectionDemo.class.getFields();
    for(Field field : fields){
      System.out.println(field.getName()); //what the variable name is
      if(field.isAnnotationPresent(Myannotation.class)){
        System.out.println(field.getName() + " has annotation present");
      }
    }
  }
  @Myannotation
  public void doStuff(){
    @Myannotation
    int a;
  }
}
