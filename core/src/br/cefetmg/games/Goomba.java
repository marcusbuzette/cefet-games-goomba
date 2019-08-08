/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.games;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 * @author marcusbuzette
 */
public class Goomba {
    
    private Sprite jogador;
    
    public Goomba (Texture textura) {
        jogador = new Sprite (textura);
        jogador.setPosition(30, 10);

    }
    
   
    
}
