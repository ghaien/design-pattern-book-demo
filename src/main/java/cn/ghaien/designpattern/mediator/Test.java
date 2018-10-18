package cn.ghaien.designpattern.mediator;

/**
 * @author guo.haien
 * @date 2018/10/12 14:46
 */
public class Test {

    public static void main(String[] args) {
        /*Mediator mediator = new ConcreteMediator();
        Colleague colleague1 = new ConcreteColleague1(mediator);
        Colleague colleague2 = new ConcreteColleague2(mediator);
        ((ConcreteMediator) mediator).setColleague1(colleague1);
        ((ConcreteMediator) mediator).setColleague2(colleague2);

        colleague1.send("同事 1 说：大家好");
        colleague2.send("同事 2 说：下午好");*/

        UnitedNations unitedNations = new UnitedNationsSecurityCouncil();
        Country USA = new USA(unitedNations);
        Country Iraq = new Iraq(unitedNations);
        ((UnitedNationsSecurityCouncil) unitedNations).setCountry1(USA);
        ((UnitedNationsSecurityCouncil) unitedNations).setCountry2(Iraq);

        USA.declare("不准研制核武器，否则要发动战争！");
        Iraq.declare("我们没有核武器，也不怕侵略。");
    }
}
