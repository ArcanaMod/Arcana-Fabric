package arcanamod.arcana.common.aspects.components;

import arcanamod.arcana.common.aspects.Aspect;
import arcanamod.arcana.common.aspects.AspectStack;

import java.util.List;
import java.util.function.Consumer;

public class AspectCell implements AspectHolder{
	private AspectStack stored = new AspectStack();
	private float capacity;
	private boolean voids = false, canInsert = true;
	// not serialized, set these yourself
	private Consumer<Float> overfillingCallback = __ -> {};
	private List<Aspect> whitelist = null;

	public AspectCell(){
		this(100);
	}

	public AspectCell(float capacity){
		this.capacity = capacity;
	}

	public AspectStack getStack(){
		return stored;
	}

	public float getCapacity(){
		return capacity;
	}

	public List<Aspect> getWhitelist(){
		return whitelist;
	}

	public boolean voids(){
		return voids;
	}

	public boolean canInsert(){
		return canInsert;
	}

	public Consumer<Float> overfillingCallback(){
		return overfillingCallback;
	}

	public void setStack(AspectStack stack){
		stored = stack;
	}

	public void setCapacity(float capacity){
		this.capacity = capacity;
	}

	public void setWhitelist(List<Aspect> whitelist){
		this.whitelist = whitelist;
	}

	public void setVoids(boolean voids){
		this.voids = voids;
	}

	public void setCanInsert(boolean canInsert){
		this.canInsert = canInsert;
	}

	public void setOverfillingCallback(Consumer<Float> callback){
		this.overfillingCallback = callback == null ? __ -> {} : callback;
	}
}