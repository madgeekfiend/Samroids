package interfaces;

import org.newdawn.slick.Input;

public interface IRenderable {
	public void update( Input input, int delta );
	public void draw();
}
