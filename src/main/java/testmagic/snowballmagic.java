package testmagic;

import bluenova.fairytailcraft.plugin.MagePluginEvent;
import java.util.HashMap;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sven
 */
public class snowballmagic extends MagePluginEvent {

    HashMap<Player, ItemStack> lastActiveItem = new HashMap<Player, ItemStack>();

    @Override
    public void callPlayerInteractEvent(PlayerInteractEvent event) {
        event.getPlayer().launchProjectile(Snowball.class);
        event.getPlayer().sendMessage("Mana decreesed!");
        lastActiveItem.put(event.getPlayer(), event.getItem());
    }

    @Override
    public void callEntityHitByProjectilEvent(ProjectileHitEvent event) {
        if (event.getEntity().getShooter() instanceof Player) {
            if (lastActiveItem.get((Player)event.getEntity().getShooter()) == null) {
                Projectile proj = (Projectile) event.getEntity();
                Entity tar = proj.getNearbyEntities(1, 1, 1).get(0);
                if (tar instanceof LivingEntity) {
                    LivingEntity target = (LivingEntity) tar;
                    target.damage(2, proj.getShooter());
                }
            }
        }
    }
}
