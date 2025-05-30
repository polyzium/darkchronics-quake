/*
 * DarkChronics-Quake, a Quake minigame plugin for Minecraft servers running PaperMC
 * 
 * Copyright (C) 2024-present Polyzium
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ru.darkchronics.quake.menus;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

import java.util.HashMap;
import java.util.Optional;

public class MenuManager {
    public static MenuManager INSTANCE;
    private HashMap<Player, Menu> menus = new HashMap<>();

    public MenuManager() {
        INSTANCE = this;
//        this.menus = new HashMap<>();
    }

//    public void put(Player player, Menu menu) {
//        menus.put(player, menu);
//    }
//
//    public Menu get(Player player) {
//        return menus.get(player);
//    }
//
//    public void remove(Player player) {
//        menus.remove(player);
//    }

//    public Menu getMenuFromView(InventoryView view) {
//        Optional<Menu> foundMenu = menus.values().stream()
//                .filter(menu -> menu.getInventory() == view.getTopInventory())
//                .findFirst();
//
//        return foundMenu.orElse(null);
//    }

    public Menu getMenuFromInventory(Inventory inventory) {
        Optional<Menu> foundMenu = menus.values().stream()
                .filter(menu -> menu.getInventory() == inventory)
                .findFirst();

        return foundMenu.orElse(null);
    }

    public void showMenu(Menu menu, Player viewer) {
        this.menus.put(viewer, menu);
        viewer.openInventory(menu.getInventory());
    }
}
