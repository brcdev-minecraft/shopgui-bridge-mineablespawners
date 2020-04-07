package net.brcdev.shopgui.bridge.mineablespawners;

import net.brcdev.shopgui.ShopGuiPlusApi;
import net.brcdev.shopgui.bridge.mineablespawners.spawner.MineableSpawnersProvider;
import net.brcdev.shopgui.exception.api.ExternalSpawnerProviderNameConflictException;
import org.bukkit.plugin.java.JavaPlugin;

public class ShopGuiBridgeMineableSpawnersPlugin extends JavaPlugin {

  private MineableSpawnersProvider spawnerProvider;

  @Override
  public void onEnable() {
    this.spawnerProvider = new MineableSpawnersProvider();
    
    hookIntoShopGui();
  }

  private void hookIntoShopGui() {
    try {
      ShopGuiPlusApi.registerSpawnerProvider(spawnerProvider);
    } catch (ExternalSpawnerProviderNameConflictException e) {
      this.getLogger().warning("Failed to hook into ShopGUI+: " + e.getMessage());
    }
  }
}
