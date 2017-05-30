package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	int currentX;
	int currentY;

	@Override
	public void create () {
		batch = new SpriteBatch();
		sprite = new Sprite(new Texture("badlogic.jpg"));

		currentX = 0;
		currentY = 0;

		sprite.setPosition(currentX,currentY);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprite.draw(batch);
		batch.end();


		Boolean jumpPressed = Gdx.input.isKeyPressed(Input.Keys.W);
		Boolean rightPressed = Gdx.input.isKeyPressed(Input.Keys.D);
		Boolean downPressed = Gdx.input.isKeyPressed(Input.Keys.S);
		Boolean leftPressed = Gdx.input.isKeyPressed(Input.Keys.A);

		Boolean shoot = Gdx.input.isKeyPressed(Input.Keys.SPACE);

		if(jumpPressed ){
			jump();
		}

		if(rightPressed) {
			right();
		}

		if(downPressed) {
			down();
		}

		if(leftPressed) {
			left();
		}

		if(shoot) {
			shoot();
		}

		sprite.setPosition(currentX,currentY);

	}


	public void jump(){
		currentY = currentY + 5;
	}


	public void right(){
		currentX = currentX + 5;
	}

	public void down() {
		currentY = currentY - 5;
	}

	public void left() {
		currentX = currentX - 5;
	}

	public void shoot() {
		
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
