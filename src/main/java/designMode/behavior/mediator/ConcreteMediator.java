package designMode.behavior.mediator;

import java.util.HashMap;

//具体的中介者类
public class ConcreteMediator extends Mediator {


	//容器
	private final HashMap<String, Colleague> colleagueMap;
	private final HashMap<String, String> interMap;

	public ConcreteMediator() {
		colleagueMap = new HashMap<>();
		interMap = new HashMap<>();
	}

	@Override
	public void Register(String colleagueName, Colleague colleague) {
		// TODO Auto-generated method stub
		colleagueMap.put(colleagueName, colleague);

		if (colleague instanceof Alarm) {
			interMap.put("Alarm", colleagueName);
		} else if (colleague instanceof CoffeeMachine) {
			interMap.put("CoffeeMachine", colleagueName);
		} else if (colleague instanceof TV) {
			interMap.put("TV", colleagueName);
		} else if (colleague instanceof Curtains) {
			interMap.put("Curtains", colleagueName);
		}

	}

	//中介者核心方法
	//根据得到的消息，完成对应任务
	//协调各个具体同事类完成任务
	@Override
	public void GetMessage(int stateChange, String colleagueName) {

		if (colleagueMap.get(colleagueName) instanceof Alarm) {
			if (stateChange == 0) {
				((CoffeeMachine) (colleagueMap.get(interMap
						.get("CoffeeMachine")))).StartCoffee();
				((TV) (colleagueMap.get(interMap.get("TV")))).StartTv();
			} else if (stateChange == 1) {
				((TV) (colleagueMap.get(interMap.get("TV")))).StopTv();
			}

		} else if (colleagueMap.get(colleagueName) instanceof CoffeeMachine) {
			((Curtains) (colleagueMap.get(interMap.get("Curtains"))))
					.UpCurtains();

		} else if (colleagueMap.get(colleagueName) instanceof TV) {

		} else if (colleagueMap.get(colleagueName) instanceof Curtains) {

		}

	}

	@Override
	public void SendMessage() {
		// TODO Auto-generated method stub

	}

}
