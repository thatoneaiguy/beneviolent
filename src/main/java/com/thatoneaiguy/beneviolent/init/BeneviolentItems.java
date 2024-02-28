package com.thatoneaiguy.beneviolent.init;

import com.thatoneaiguy.beneviolent.Beneviolent;
import com.thatoneaiguy.beneviolent.item.Bouquet;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class BeneviolentItems {

	public static final ItemGroup BENEVIOLENCE = FabricItemGroupBuilder.build(
		new Identifier(Beneviolent.MODID, "beneviolence"), () -> new ItemStack(BeneviolentItems.BOUQUET));

	public static final Item BOUQUET = registerItem("bouquet", new Bouquet(new QuiltItemSettings().group(BENEVIOLENCE).maxCount(1)));

	public static final Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(Beneviolent.MODID, name), item);
	}

	public static void register() {
	}

}
