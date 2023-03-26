package net.fabricmc.myfirstmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.myfirstmod.entities.LaserEntity;
import net.fabricmc.myfirstmod.items.LaserItem;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.logging.Logger;

public class MyFirstMod implements ModInitializer {
	public static final Item LASER_ITEM = new LaserItem(new FabricItemSettings());
	public static final Logger LOGGER = Logger.getLogger("modid");

	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier("modid", "laser"), LASER_ITEM);

		Registry.register(
				Registries.ENTITY_TYPE,
				new Identifier("examplemod", "laser_entity"),
				FabricEntityTypeBuilder.<LaserEntity>create(SpawnGroup.MISC, LaserEntity::new)
						.dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build()
		);
	}
}
