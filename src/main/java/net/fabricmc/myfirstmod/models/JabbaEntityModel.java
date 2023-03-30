package net.fabricmc.myfirstmod.models;

import com.google.common.collect.ImmutableList;
import net.fabricmc.myfirstmod.entities.JabbaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class JabbaEntityModel extends EntityModel<JabbaEntity> {
	private final ModelPart base;
	public JabbaEntityModel(ModelPart part) {
		base = part.getChild("Body");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		modelPartData.addChild("Bottom", ModelPartBuilder.create()
				.uv(272, 220).cuboid(-30.0F, -14.0F, -28.0F, 2.0F, 14.0F, 56.0F)
				.uv(272, 220).cuboid(28.0F, -14.0F, -28.0F, 2.0F, 14.0F, 56.0F)
				.uv(90, 316).cuboid(24.0F, -10.0F, 32.0F, 2.0F, 10.0F, 46.0F)
				.uv(0, 0).cuboid(16.0F, -6.0F, 80.0F, 2.0F, 6.0F, 30.0F)
				.uv(144, 158).cuboid(8.0F, -4.0F, 112.0F, 2.0F, 4.0F, 14.0F)
				.uv(144, 158).cuboid(-10.0F, -4.0F, 112.0F, 2.0F, 4.0F, 14.0F)
				.uv(0, 0).cuboid(-18.0F, -6.0F, 80.0F, 2.0F, 6.0F, 30.0F)
				.uv(90, 316).cuboid(-26.0F, -10.0F, 32.0F, 2.0F, 10.0F, 46.0F)
				.uv(250, 290).cuboid(-16.0F, -8.0F, 80.0F, 32.0F, 8.0F, 32.0F)
				.uv(0, 36).cuboid(-8.0F, -6.0F, 112.0F, 16.0F, 6.0F, 16.0F)
				.uv(0, 158).cuboid(-24.0F, -12.0F, 32.0F, 48.0F, 12.0F, 48.0F)
				.uv(0, 0).cuboid(-28.0F, -16.0F, -32.0F, 56.0F, 16.0F, 64.0F)
				.uv(308, 100).cuboid(-26.0F, -16.0F, -34.0F, 52.0F, 16.0F, 2.0F),
				ModelTransform.NONE);

		modelPartData.addChild("Bottom", ModelPartBuilder.create()
				.uv(272, 220).cuboid(-30.0F, -14.0F, -28.0F, 2.0F, 14.0F, 56.0F)
				.uv(272, 220).cuboid(28.0F, -14.0F, -28.0F, 2.0F, 14.0F, 56.0F)
				.uv(90, 316).cuboid(24.0F, -10.0F, 32.0F, 2.0F, 10.0F, 46.0F)
				.uv(0, 0).cuboid(16.0F, -6.0F, 80.0F, 2.0F, 6.0F, 30.0F)
				.uv(144, 158).cuboid(8.0F, -4.0F, 112.0F, 2.0F, 4.0F, 14.0F)
				.uv(144, 158).cuboid(-10.0F, -4.0F, 112.0F, 2.0F, 4.0F, 14.0F)
				.uv(0, 0).cuboid(-18.0F, -6.0F, 80.0F, 2.0F, 6.0F, 30.0F)
				.uv(90, 316).cuboid(-26.0F, -10.0F, 32.0F, 2.0F, 10.0F, 46.0F)
				.uv(250, 290).cuboid(-16.0F, -8.0F, 80.0F, 32.0F, 8.0F, 32.0F)
				.uv(0, 36).cuboid(-8.0F, -6.0F, 112.0F, 16.0F, 6.0F, 16.0F)
				.uv(0, 158).cuboid(-24.0F, -12.0F, 32.0F, 48.0F, 12.0F, 48.0F)
				.uv(0, 0).cuboid(-28.0F, -16.0F, -32.0F, 56.0F, 16.0F, 64.0F)
				.uv(308, 100).cuboid(-26.0F, -16.0F, -34.0F, 52.0F, 16.0F, 2.0F),
				ModelTransform.NONE);

		modelPartData.addChild("BottomTailEndFatEndExtension", ModelPartBuilder.create()
				.uv(0, 16).cuboid(130.0F, -4.0F, -4.0F, 6.0F, 4.0F, 8.0F)
				.uv(144, 158).cuboid(128.0F, -4.0F, -7.0F, 2.0F, 4.0F, 14.0F),
				ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		modelPartData.addChild("Middle", ModelPartBuilder.create()
				.uv(0, 80).cuboid(-26.0F, -32.0F, -30.0F, 52.0F, 16.0F, 62.0F)
				.uv(240, 60).cuboid(-24.0F, -32.0F, -32.0F, 48.0F, 16.0F, 2.0F)
				.uv(280, 142).cuboid(26.0F, -30.0F, -26.0F, 2.0F, 14.0F, 52.0F)
				.uv(280, 142).cuboid(-28.0F, -30.0F, -26.0F, 2.0F, 14.0F, 52.0F)
				.uv(144, 170).cuboid(-22.0F, -24.0F, 32.0F, 44.0F, 12.0F, 48.0F)
				.uv(186, 327).cuboid(22.0F, -22.0F, 32.0F, 2.0F, 10.0F, 44.0F)
				.uv(186, 327).cuboid(-24.0F, -22.0F, 32.0F, 2.0F, 10.0F, 44.0F)
				.uv(304, 0).cuboid(-14.0F, -16.0F, 80.0F, 28.0F, 8.0F, 32.0F)
				.uv(0, 80).cuboid(14.0F, -14.0F, 80.0F, 2.0F, 6.0F, 28.0F)
				.uv(0, 80).cuboid(-16.0F, -14.0F, 80.0F, 2.0F, 6.0F, 28.0F)
				.uv(0, 114).cuboid(-6.0F, -12.0F, 112.0F, 12.0F, 6.0F, 14.0F)
				.uv(0, 0).cuboid(6.0F, -10.0F, 112.0F, 2.0F, 4.0F, 12.0F)
				.uv(0, 0).cuboid(-8.0F, -10.0F, 112.0F, 2.0F, 4.0F, 12.0F),
				ModelTransform.NONE);

		modelPartData.addChild("MiddleTailEndFatEndExtension", ModelPartBuilder.create()
				.uv(0, 80).cuboid(128.0F, -6.0F, -3.0F, 6.0F, 2.0F, 6.0F)
				.uv(34, 14).cuboid(126.0F, -10.0F, -5.0F, 2.0F, 4.0F, 10.0F),
				ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		modelPartData.addChild("Top", ModelPartBuilder.create()
				.uv(166, 80).cuboid(-24.0F, -48.0F, -28.0F, 48.0F, 16.0F, 46.0F)
				.uv(332, 240).cuboid(-22.0F, -48.0F, -30.0F, 44.0F, 16.0F, 2.0F)
				.uv(234, 330).cuboid(-22.0F, -48.0F, 18.0F, 44.0F, 16.0F, 12.0F)
				.uv(42, 324).cuboid(-18.0F, -64.0F, 16.0F, 36.0F, 16.0F, 10.0F)
				.uv(0, 218).cuboid(-21.0F, -76.0F, -26.0F, 42.0F, 28.0F, 42.0F)
				.uv(126, 230).cuboid(-19.0F, -74.0F, -28.0F, 38.0F, 28.0F, 2.0F)
				.uv(130, 276).cuboid(-19.0F, -78.0F, -24.0F, 38.0F, 2.0F, 38.0F)
				.uv(0, 288).cuboid(-17.0F, -80.0F, -22.0F, 34.0F, 2.0F, 34.0F)
				.uv(204, 142).cuboid(-14.0F, -82.0F, -17.0F, 27.0F, 2.0F, 24.0F)
				.uv(306, 330).cuboid(24.0F, -46.0F, -24.0F, 2.0F, 14.0F, 40.0F)
				.uv(306, 330).cuboid(-26.0F, -46.0F, -24.0F, 2.0F, 14.0F, 40.0F)
				.uv(0, 324).cuboid(-23.0F, -74.0F, -24.0F, 2.0F, 26.0F, 38.0F)
				.uv(0, 324).cuboid(21.0F, -74.0F, -24.0F, 2.0F, 26.0F, 38.0F)
				.uv(176, 0).cuboid(-20.0F, -36.0F, 30.0F, 40.0F, 12.0F, 48.0F)
				.uv(168, 230).cuboid(-18.0F, -38.0F, 30.0F, 36.0F, 2.0F, 44.0F)
				.uv(308, 60).cuboid(-12.0F, -24.0F, 78.0F, 24.0F, 8.0F, 32.0F)
				.uv(332, 208).cuboid(-10.0F, -26.0F, 78.0F, 20.0F, 2.0F, 30.0F)
				.uv(0, 158).cuboid(-4.0F, -18.0F, 110.0F, 8.0F, 6.0F, 14.0F)
				.uv(166, 80).cuboid(-2.0F, -20.0F, 110.0F, 4.0F, 2.0F, 12.0F)
				.uv(186, 316).cuboid(20.0F, -34.0F, 30.0F, 2.0F, 10.0F, 44.0F)
				.uv(186, 316).cuboid(-22.0F, -34.0F, 30.0F, 2.0F, 10.0F, 44.0F)
				.uv(140, 316).cuboid(-14.0F, -22.0F, 80.0F, 2.0F, 6.0F, 26.0F)
				.uv(140, 316).cuboid(12.0F, -22.0F, 80.0F, 2.0F, 6.0F, 26.0F)
				.uv(34, 14).cuboid(4.0F, -16.0F, 112.0F, 2.0F, 4.0F, 10.0F)
				.uv(34, 0).cuboid(-6.0F, -16.0F, 112.0F, 2.0F, 4.0F, 10.0F),
				ModelTransform.NONE);

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(JabbaEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		ImmutableList.of(this.base).forEach((modelRenderer) -> {
			modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		});
	}
}