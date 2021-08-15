package StackAndQueue.AnimalShelter;

public class Animals {
    private String type;
    private String name;
    public int order;

    public void setName(String name){
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void printName(){
        System.out.println("Pet's name is: " + name);
    }

    /**
     * Inserting the element with Order and incrementing the order by one for every new element.
     * Latest element will maintain the largest value of the Order.
     *
     * @param animal
     * @return boolean value
     */
    public boolean isOlderThan(Animals animal) {
        return this.order < animal.getOrder();
    }
}
