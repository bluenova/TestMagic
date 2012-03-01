package testmagic;


import bluenova.fairytailcraft.plugin.MagePluginEvent;
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

    @Override
    public void callPlayerInteractEvent(PlayerInteractEvent event) {
        event.getPlayer().throwSnowball();
        event.getPlayer().sendMessage("Mana decreesed!");
    }    
}
