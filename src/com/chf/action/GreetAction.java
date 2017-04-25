package com.chf.action;

public class GreetAction extends Action {
    private static final long serialVersionUID = 4878247652427455524L;
    @Override
    public String execute(){
        GreetFactory greetFactory = new GreetFactory();
        Greet greetStu = greetFactory.getShow(0);
        greetStu.show();
        Greet greetTea = greetFactory.getShow(1);
        greetTea.show();
        Greet greetAdm = greetFactory.getShow(2);
        greetAdm.show();
        return "viewMark.jsp";
    }
}
 