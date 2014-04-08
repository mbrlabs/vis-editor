/*******************************************************************************
 * Copyright 2014 Pawel Pastuszak
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package pl.kotcrab.vis.sceneeditor.example;

import pl.kotcrab.core.KotcrabText;
import pl.kotcrab.core.KotcrabTextSupport;
import pl.kotcrab.vis.sceneeditor.SceneEditor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ExampleSceneKotcrabText extends AbstractScene
{
	private SceneEditor sceneEditor;
	
	private Texture bushTexture;
	private Texture netTexture;
	
	private Sprite bush1;
	private Sprite bush2;
	private Sprite net1;
	private Sprite net2;
	
	private KotcrabText text;
	private KotcrabText text2;
	
	public ExampleSceneKotcrabText(OrthographicCamera camera)
	{
		// SceneEditorConfig.backupFolderPath = "F:\\Projekty\\VisSceneEditor\\backup\\"; // Optonal, will backup your files before
		// saving new scene
		
		// SceneEditorConfig.assetsFolderPath THIS IS REQUIRED, it is set in desktop project launcher, see DesktopLauncher.java in desktop project
		
		bushTexture = new Texture(Gdx.files.internal("bush.png"));
		netTexture = new Texture(Gdx.files.internal("net.png"));
		
		bush1 = new Sprite(bushTexture);
		bush2 = new Sprite(bushTexture);
		net1 = new Sprite(netTexture);
		net2 = new Sprite(netTexture);
		
		text = new KotcrabText(new BitmapFont(Gdx.files.internal("data/arial.fnt")), "Just some random text", false, 0, 0);
		text2 = new KotcrabText(new BitmapFont(Gdx.files.internal("data/arial.fnt")), "Just some random text with orign centred", true, 0, 0);
		
		sceneEditor = new SceneEditor(Gdx.files.internal("kotcrabtext_scene.json"), camera, true);
		sceneEditor.registerSupport(KotcrabText.class, new KotcrabTextSupport());
		sceneEditor.add(bush1, "bush1").add(bush2, "bush2").add(net1, "net1").add(net2, "net2");
		sceneEditor.add(text, "text");
		sceneEditor.add(text2, "text2");
		sceneEditor.load();
		sceneEditor.enable();
	}
	
	@Override
	public void render(SpriteBatch batch)
	{
		batch.begin();
		bush1.draw(batch);
		bush2.draw(batch);
		net1.draw(batch);
		net2.draw(batch);
		text.draw(batch);
		text2.draw(batch);
		batch.end();
		
		sceneEditor.render();
	}
	
	@Override
	public void dispose()
	{
		bushTexture.dispose();
		netTexture.dispose();
		sceneEditor.dispose();
	}
	
	@Override
	public void resize()
	{
		sceneEditor.resize();
	}
}
