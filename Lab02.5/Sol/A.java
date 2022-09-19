public class A {

    public void m1() {
	System.out.println("A 1");
    }

    public void m2() {
	System.out.println("A 2");
    }

    public String toString() {
	return "A";
    }

    public static void main (String [] args) {
	A[] elements = {new C(), new A(), new D(), new B()};
	for (int i = 0; i < elements.length; i++) {
	    System.out.println(elements[i]);
	    elements[i].m1();
	    elements[i].m2();
	    System.out.println();
	}
    }
}

class B extends A {
    public void m2() {
	System.out.println("B 2");
    }
}

class C extends A {
    public void m1() {
	System.out.println("C 1");
    }

    public String toString() {
	return "C";
    }
}

class D extends C {
    public void m2() {
	System.out.println("D 2");
    }
}
