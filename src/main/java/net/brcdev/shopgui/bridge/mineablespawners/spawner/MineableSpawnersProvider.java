package net.brcdev.shopgui.bridge.mineablespawners.spawner;

import com.dnyferguson.mineablespawners.MineableSpawners;
import net.brcdev.shopgui.spawner.external.provider.ExternalSpawnerProvider;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class MineableSpawnersProvider implements ExternalSpawnerProvider {

  @Override
  public String getName() {
    return "MineableSpawners";
  }

  @Override
  public ItemStack getSpawnerItem(EntityType entityType) {
    return MineableSpawners.getApi().getSpawnerFromEntityType(entityType);
  }

  @Override
  public EntityType getSpawnerEntityType(ItemStack itemStack) {
    return MineableSpawners.getApi().getEntityTypeFromItemStack(itemStack);
  }
}
