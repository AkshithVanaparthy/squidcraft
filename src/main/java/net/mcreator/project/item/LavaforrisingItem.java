
package net.mcreator.project.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BucketItem;

import net.mcreator.project.init.ProjectModFluids;

public class LavaforrisingItem extends BucketItem {
	public LavaforrisingItem() {
		super(ProjectModFluids.LAVAFORRISING, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(CreativeModeTab.TAB_MISC));
	}
}
