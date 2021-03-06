package omtteam.openmodularturrets.compatability;

import igwmod.gui.GuiWiki;
import igwmod.gui.tabs.BaseWikiTab;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import omtteam.openmodularturrets.handler.ConfigHandler;
import omtteam.openmodularturrets.init.ModBlocks;

/**
 * Created by Keridos on 23/01/2015.
 * This Class
 */
class OpenModularTurretsWikiTab extends BaseWikiTab {
    public OpenModularTurretsWikiTab() {
        pageEntries.add("block/turret_base");
        pageEntries.add("block/lever_block");

        if (ConfigHandler.getDisposableTurretSettings().isEnabled()) {
            pageEntries.add("block/disposable_item_turret");
        }

        if (ConfigHandler.getPotatoCannonTurretSettings().isEnabled()) {
            pageEntries.add("block/potato_cannon_turret");
        }

        if (ConfigHandler.getGunTurretSettings().isEnabled()) {
            pageEntries.add("block/machine_gun_turret");
        }

        if (ConfigHandler.getIncendiaryTurretSettings().isEnabled()) {
            pageEntries.add("block/incendiary_turret");
        }

        if (ConfigHandler.getGrenadeTurretSettings().isEnabled()) {
            pageEntries.add("block/grenade_turret");
        }

        if (ConfigHandler.getRelativisticTurretSettings().isEnabled()) {
            pageEntries.add("block/relativistic_turret");
        }
        if (ConfigHandler.getRocketTurretSettings().isEnabled()) {
            pageEntries.add("block/rocket_turret");
        }

        if (ConfigHandler.getTeleporterTurretSettings().isEnabled()) {
            pageEntries.add("block/teleporter_turret");
        }

        if (ConfigHandler.getLaserTurretSettings().isEnabled()) {
            pageEntries.add("block/laser_turret");
        }

        if (ConfigHandler.getRailgunTurretSettings().isEnabled()) {
            pageEntries.add("block/rail_gun_turret");
        }
    }

    @Override
    public String getName() {
        return "OpenModularTurrets";
    }

    @Override
    public ItemStack renderTabIcon(GuiWiki gui) {
        return new ItemStack(ModBlocks.machineGunTurret);
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected String getPageName(String pageEntry) {
        if (pageEntry.startsWith("item") || pageEntry.startsWith("block")) {
            return I18n.format(pageEntry.replace("/", ".").replace("block", "tile") + ".name");
        } else {
            return I18n.format("igwtab.entry." + pageEntry);
        }
    }

    @Override
    protected String getPageLocation(String pageEntry) {
        if (pageEntry.startsWith("item") || pageEntry.startsWith("block")) {
            return pageEntry;
        }
        return "omtteam.openmodularturrets:menu/" + pageEntry;
    }
}
