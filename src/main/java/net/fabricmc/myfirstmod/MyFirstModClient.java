package net.fabricmc.myfirstmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.myfirstmod.models.JabbaEntityModel;
import net.fabricmc.myfirstmod.renderers.JabbaEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class MyFirstModClient implements ClientModInitializer {
	public static final EntityModelLayer JABBA_MODEL_LAYER = new EntityModelLayer(new Identifier("modid", "jabba"), "main");

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(MyFirstMod.JABBA_ENTITY, JabbaEntityRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(JABBA_MODEL_LAYER, JabbaEntityModel::getTexturedModelData);
	}
}
