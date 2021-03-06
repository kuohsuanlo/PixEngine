package test;

import java.awt.event.KeyEvent;

import com.majoolwip.core.GameContainer;
import com.majoolwip.core.Renderer;
import com.majoolwip.core.components.Collider;
import com.majoolwip.core.components.GameObject;

public class Player extends GameObject
{
	public Player(int x, int y)
	{
		setTag("player");
		this.x = x;
		this.y = y;
		w = 16;
		h = 64;
		addComponent(new Collider());
	}

	@Override
	public void update(GameContainer gc, float dt)
	{
		if(gc.getInput().isKey(KeyEvent.VK_W))
		{
			y -= 75 * dt;

			if(y < 0)
			{
				y = 0;
			}
		}
		
		if(gc.getInput().isKey(KeyEvent.VK_S))
		{
			y += 75 * dt;
			
			if(y + h > gc.getHeight())
			{
				y = gc.getHeight() - h;
			}
		}
		
		updateComponents(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r)
	{
		r.drawFillRect((int)x, (int)y, (int)w, (int)h, 0xffffffff);
	}

	@Override
	public void dispose()
	{

	}

	@Override
	public void componentEvent(String name, GameObject object)
	{

	}

}
