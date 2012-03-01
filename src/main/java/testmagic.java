/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import bluenova.fairytailcraft.plugin.MagePlugin;
import bluenova.fairytailcraft.plugin.MagePluginManager;

/**
 *
 * @author Sven
 */
public class testmagic implements MagePlugin {

    private MagePluginManager manager;
    public void setPluginManager(MagePluginManager manager) {
        this.manager = manager;
    }

    public void loadPlugin() {
        System.out.println("TestMagic Successfully Load!");
    }

    public void unloadPlugin() {
        System.out.println("TestMagic Successfully Unload!");
    }
    
}
