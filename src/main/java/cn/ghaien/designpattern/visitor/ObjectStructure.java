package cn.ghaien.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guo.haien
 * @date 2018/10/18 13:36
 */
public class ObjectStructure {

    private List<Person> people = new ArrayList<>();

    public void attach(Person person) {
        people.add(person);
    }

    public void detach(Person person) {
        people.remove(person);
    }

    public void display(Action action) {
        for (Person person : people) {
            person.accept(action);
        }
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
