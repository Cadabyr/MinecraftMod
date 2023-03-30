package net.fabricmc.myfirstmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.myfirstmod.models.JabbaEntityModel;
import net.fabricmc.myfirstmod.renderers.JabbaEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class MyFirstModClient implements ClientModInitializer {
	public static final EntityModelLayer MODEL_JABBA_LAYER = new EntityModelLayer(new Identifier("modid", "jabba"), "main");

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(net.fabricmc.myfirstmod.MyFirstMod.JABBA_ENTITY, JabbaEntityRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(MODEL_JABBA_LAYER, JabbaEntityModel::getTexturedModelData);
	}
}
