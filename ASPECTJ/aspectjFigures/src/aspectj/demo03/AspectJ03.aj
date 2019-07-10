package aspectj.demo03;

// Note: Must import FigureElement & Point

public aspect AspectJ03 {

    // pointcut: Include move actions
    pointcut moveAction() :  (
            call(void FigureElement.move(int,int)) ||
                    call(void Point.setX(int))              ||
                    call(void Point.setY(int))
            )
            && within (aspectj.demo03.ClassTest03);

    before() : moveAction()  {
        System.out.println("before move");
    }

}