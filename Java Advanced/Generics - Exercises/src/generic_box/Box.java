package generic_box;



public class Box <T>{
   T element;

    public Box(T element) {
       this.element = element;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",element.getClass().getName(),element);
    }
}
