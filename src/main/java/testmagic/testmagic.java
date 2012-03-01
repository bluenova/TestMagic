package testmagic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import bluenova.fairytailcraft.event.MageEventType;
import bluenova.fairytailcraft.plugin.MagePlugin;
import bluenova.fairytailcraft.plugin.MagePluginManager;

/**
 *
 * @author Sven
 */
public class testmagic implements MagePlugin {
    private String magicName = "TestMagic";
    private MagePluginManager manager;
    public void setPluginManager(MagePluginManager manager) {
        this.manager = manager;
    }

    public void loadPlugin() {
        manager.registerMagic("snowball", magicName, 1, 10, new snowballmagic(), MageEventType.INTERACT);
        System.out.println("TestMagic Successfully Load!");
    }

    public void unloadPlugin() {
        System.out.println("TestMagic Successfully Unload!");
    }

    public String getMagicName() {
        return magicName;
    } 
}
