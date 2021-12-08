package arcanamod.arcana.common.aspects;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class AspectStack{

	private float amount;
	private Aspect aspect;
	
	public boolean isEmpty(){
		return amount == 0 || aspect == Aspects.EMPTY;
	}
	
	public void setAspect(Aspect aspect){
		this.aspect = aspect;
	}
	
	public float getAmount(){
		return amount;
	}
	
	public void setAmount(float amount){
		this.amount = amount <= 0 ? 0 : amount;
	}
	
	public Aspect getAspect(){
		return aspect;
	}
	
	public AspectStack(){
		this(Aspects.EMPTY, 0);
	}
	
	public AspectStack(Aspect aspect){
		this(aspect, 1);
	}
	
	public AspectStack(Aspect aspect, float amount){
		boolean isEmpty = amount <= 0 || aspect == Aspects.EMPTY;
		
		this.aspect = isEmpty ? Aspects.EMPTY : aspect;
		this.amount = isEmpty ? 0 : amount;
	}
	
	@Override
	public String toString(){
		return "AspectStack{" +
				"amount=" + amount +
				", aspect=" + aspect +
				'}';
	}
	
	@NotNull
	public NbtCompound toNbt(){
		NbtCompound tag = new NbtCompound();
		tag.putString("aspect", getAspect().getId().toString());
		tag.putFloat("amount", getAmount());
		return tag;
	}
	
	@NotNull
	public static AspectStack fromNbt(@NotNull NbtCompound tag){
		return new AspectStack(Aspects.ASPECTS.get(new Identifier(tag.getString("aspect"))), tag.getFloat("amount"));
	}
	
	public boolean equals(Object o){
		if(this == o)
			return true;
		if(o == null || getClass() != o.getClass())
			return false;
		AspectStack stack = (AspectStack)o;
		return Float.compare(stack.amount, amount) == 0 &&
				Objects.equals(aspect, stack.aspect);
	}
	
	public int hashCode(){
		return Objects.hash(amount, aspect);
	}
}