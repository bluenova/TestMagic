package testmagic;


import bluenova.fairytailcraft.plugin.MagePluginEvent;
import net.minecraft.server.Block;
import net.minecraft.server.Item;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sven
 */
public class snowballmagic extends MagePluginEvent {
    Material lastActiveItem;

    @Override
    public void callPlayerInteractEvent(PlayerInteractEvent event) {
        event.getPlayer().throwSnowball();
        event.getPlayer().sendMessage("Mana decreesed!");
        lastActiveItem = event.getItem().getType();
    }

    @Override
    public void callPlayerHitByProjectilEvent(ProjectileHitEvent event) {
        if(lastActiveItem == Material.AIR) {
            Projectile proj = (Projectile) event.getEntity();
            Player target = (Player)proj.getNearbyEntities(1, 1, 1).get(0);
            target.damage(2, proj.getShooter());            
        }
    }
}
