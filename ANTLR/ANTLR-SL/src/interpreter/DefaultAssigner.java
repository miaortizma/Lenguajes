package interpreter;

public class DefaultAssigner {

    public static void AssignIfPossible(Object A, Object B) {
        if(A instanceof Assignable) {
            Assignable assignableA = (Assignable) A;
            assignableA.AssignIfPossible(B);
        } else if (!A.getClass().equals(B.getClass())) {
            throw new UnsupportedOperationException("Can't assign " + B.getClass() + " to " + A.getClass());)
        }
    }

}
