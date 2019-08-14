/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author marcusbuzette
 */
public class Goomba {
    
    private Sprite jogador;
    private TextureRegion[][] quadrosGoomba;
    private Animation andarParaFrente;
    private Animation andarParaTras;
    private Animation andarParaEsquerda;
    private Animation andarParaDireita;
    float tempoDaAnimacao;
    
    public Goomba (Texture textura) {
        
        jogador = new Sprite (textura);
        quadrosGoomba = TextureRegion.split(textura, 21, 24);
        andarParaFrente = new Animation(0.1f,
            quadrosGoomba[0][0], 
            quadrosGoomba[0][1],
            quadrosGoomba[0][2],
            quadrosGoomba[0][3],
            quadrosGoomba[0][4]);
        
        andarParaTras = new Animation(0.1f,
            quadrosGoomba[2][0], 
            quadrosGoomba[2][1],
            quadrosGoomba[2][2],
            quadrosGoomba[2][3],
            quadrosGoomba[2][4]);
        
        andarParaDireita = new Animation(0.1f,
            quadrosGoomba[1][0], 
            quadrosGoomba[1][1],
            quadrosGoomba[1][2],
            quadrosGoomba[1][3],
            quadrosGoomba[1][4]);
        
        andarParaEsquerda = new Animation(0.1f,
            quadrosGoomba[3][0], 
            quadrosGoomba[3][1],
            quadrosGoomba[3][2],
            quadrosGoomba[3][3],
            quadrosGoomba[3][4]);
        andarParaFrente.setPlayMode(PlayMode.LOOP_PINGPONG);
//        andarParaTras.setPlayMode(PlayMode.LOOP_PINGPONG);
//        andarParaDireita.setPlayMode(PlayMode.LOOP_PINGPONG);
//        andarParaEsquerda.setPlayMode(PlayMode.LOOP_PINGPONG);
        tempoDaAnimacao = 0;
        jogador.setPosition(30, 10);

    }
    
   public void update () {
       tempoDaAnimacao += Gdx.graphics.getDeltaTime();
      if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (jogador.getX() <=  Gdx.graphics.getWidth() - 21) {
                jogador.setPosition(jogador.getX() + 1, jogador.getY());
            }
            
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (jogador.getY() >= 0 ) {
                jogador.setPosition(jogador.getX(), jogador.getY() - 1);
            }
            
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (jogador.getX() >= 0 ) {
               jogador.setPosition(jogador.getX() - 1, jogador.getY()); 
            }
            
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (jogador.getY() <=  Gdx.graphics.getHeight()- 24) {
                jogador.setPosition(jogador.getX(), jogador.getY() + 1);
            }
            
        } 
   }
   
   public void render (SpriteBatch batch) {
       // jogador.draw(batch);
       batch.draw((TextureRegion)
            andarParaFrente.getKeyFrame(tempoDaAnimacao), jogador.getX(), jogador.getY());
   }
    
}
