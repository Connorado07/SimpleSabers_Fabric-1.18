package io.ronnox.simplesabers.tools;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class LightsaberToolMaterial implements ToolMaterial {
    public static final LightsaberToolMaterial INSTANCE = new LightsaberToolMaterial();

    @Override
    public int getDurability() {
        return 12387;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6.0F;
    }

    @Override
    public float getAttackDamage() {
        return 3.0F;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 2;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.PHANTOM_MEMBRANE);
    }
}
