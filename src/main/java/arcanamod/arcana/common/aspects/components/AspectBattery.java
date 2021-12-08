package arcanamod.arcana.common.aspects.components;

import java.util.ArrayList;
import java.util.List;

public class AspectBattery implements AspectHandler{

	private final List<AspectHolder> holders = new ArrayList<>();

	public List<AspectHolder> getHolders(){
		return holders;
	}

	public static AspectBattery merge(AspectBattery defaultBattery, AspectBattery... batteries){
		for(AspectBattery battery : batteries)
			defaultBattery.getHolders().addAll(battery.getHolders());
		return defaultBattery;
	}
}