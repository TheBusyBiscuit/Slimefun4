package io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.auto_crafters;

import java.util.ArrayList;

import javax.annotation.Nonnull;

import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.implementation.items.multiblocks.EnhancedCraftingTable;
import io.github.thebusybiscuit.slimefun4.implementation.tasks.RecipeChoiceTask;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;

/**
 * This {@link AbstractRecipe} implementation stands for a {@link SlimefunItem} which
 * is crafted using an {@link EnhancedCraftingTable}.
 * 
 * @author TheBusyBiscuit
 * 
 * @see EnhancedCraftingTable
 * @see EnhancedAutoCrafter
 *
 */
class EnhancedRecipe extends AbstractRecipe {

    private final int[] slots = { 11, 12, 13, 20, 21, 22, 29, 30, 31 };
    private final SlimefunItem item;

    EnhancedRecipe(@Nonnull SlimefunItem item) {
        super(new ArrayList<>(), item.getRecipeOutput());
        this.item = item;

        for (int i = 0; i < 9; i++) {
            ItemStack ingredient = item.getRecipe()[i];
            getInputs().add(stack -> SlimefunUtils.isItemSimilar(stack, ingredient, true));
        }
    }

    @Override
    public void show(@Nonnull ChestMenu menu, @Nonnull RecipeChoiceTask task) {
        menu.addItem(24, getResult().clone(), ChestMenuUtils.getEmptyClickHandler());
        ItemStack[] recipe = item.getRecipe();

        for (int i = 0; i < 9; i++) {
            menu.addItem(slots[i], recipe[i], ChestMenuUtils.getEmptyClickHandler());
        }
    }

}