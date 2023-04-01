package net.fabricmc.myfirstmod.renderers;

import net.fabricmc.myfirstmod.MyFirstModClient;
import net.fabricmc.myfirstmod.entities.JabbaEntity;
import net.fabricmc.myfirstmod.models.JabbaEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class JabbaEntityRenderer extends MobEntityRenderer<JabbaEntity, JabbaEntityModel> {
    public JabbaEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new JabbaEntityModel(context.getPart(MyFirstModClient.JABBA_MODEL_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(JabbaEntity entity) {
        return new Identifier("modid", "textures/entity/jabba.png");
    }
}
