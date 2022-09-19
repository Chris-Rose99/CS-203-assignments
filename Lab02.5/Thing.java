public class Thing {

    // field
    private Object item;
   
    public Thing(Object obj) {
	item = obj;
    }

    public String toString() {
        String result = item.toString();
	result = result.substring(result.indexOf("Object"));
	return result;
    }

    public boolean isLast() {
	return false;
    }
}


class EndThing extends Thing {

    public EndThing() {
	super(null);
    }

    public boolean isLast() {
	return true;
    }

    public String toString() {
	return "######";
    }
}
