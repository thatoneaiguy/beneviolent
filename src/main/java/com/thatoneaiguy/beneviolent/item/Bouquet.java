package com.thatoneaiguy.beneviolent.item;

import com.thatoneaiguy.beneviolent.init.BeneviolentItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class Bouquet extends Item {

	public Bouquet(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

		Item item = (Item) user.getItemsHand();

		gasSpawner(user, item, world);

		return super.use(world, user, hand);
	}

	private void gasSpawner(PlayerEntity player, Item item, World world) {
		for (PlayerEntity playerEntity : getTargetsWithinRange(new Vec3d(player.getX(), player.getY(), player.getZ()), 24, 24, player.getWorld())) {
			System.out.println("YES");
		}
    }

	public static List<PlayerEntity> getTargetsWithinRange(Vec3d areaCenter, double range, double height, World world) {
		List<PlayerEntity> targetsWithinRange = new ArrayList<>();

		for (PlayerEntity player : world.getPlayers()) {
			Vec3d playerPos = player.getPos();
			if (isWithinCylinder(playerPos, areaCenter, range, height)) {
				for(ItemStack stack : player.getInventory().main) {
					if (stack.getItem() == BeneviolentItems.BOUQUET) {
						targetsWithinRange.add(player);
					}
				}
			}
		}
		return targetsWithinRange;
	}

	private static boolean isWithinCylinder(Vec3d point, Vec3d center, double radius, double height) {
		double dx = point.x - center.x;
		double dz = point.z - center.z;
		double distanceSquared = dx * dx + dz * dz;
		return distanceSquared < (radius * radius) && Math.abs(point.y - center.y) < (height / 2.0);
	}
}
