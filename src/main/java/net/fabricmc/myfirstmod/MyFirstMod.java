package net.fabricmc.myfirstmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.myfirstmod.entities.JabbaEntity;
import net.fabricmc.myfirstmod.entities.LaserEntity;
import net.fabricmc.myfirstmod.items.LaserItem;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.logging.Logger;

public class MyFirstMod implements ModInitializer {
	public static final Item LASER_ITEM = new LaserItem(new FabricItemSettings());
	public static final EntityType<JabbaEntity> JABBA_ENTITY = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier("modid", "jabba"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, JabbaEntity::new).dimensions(EntityDimensions.fixed(4.0f, 12.0f)).build()
	);
	public static final Logger LOGGER = Logger.getLogger("modid");

	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier("modid", "laser"), LASER_ITEM);

		Registry.register(
				Registries.ENTITY_TYPE,
				new Identifier("modid", "laser_entity"),
				FabricEntityTypeBuilder.<LaserEntity>create(SpawnGroup.MISC, LaserEntity::new)
						.dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build()
		);

		FabricDefaultAttributeRegistry.register(JABBA_ENTITY, JabbaEntity.createMobAttributes());
	}
}
