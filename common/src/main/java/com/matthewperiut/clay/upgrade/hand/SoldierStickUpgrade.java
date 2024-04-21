package com.matthewperiut.clay.upgrade.hand;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import com.matthewperiut.clay.upgrade.ISoldierUpgrade;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class SoldierStickUpgrade implements ISoldierUpgrade {

    public static final Identifier IDENTIFIER = new Identifier(ClayMod.MOD_ID, "upgrades/soldier/stick_upgrade");

    protected static final UUID MODIFIER_ID = UUID.randomUUID();


    public ItemStack getUpgradeItem() {
        return new ItemStack(Items.STICK, 1);
    }

    public boolean canUpgrade(ItemStack itemStack, SoldierDollEntity soldier) {
        return !soldier.upgrades.contains(this) && itemStack.isOf(Items.STICK);
    }

    public void onAdd(SoldierDollEntity soldier) {
        if (soldier.getWorld().isClient()) {
            return;
        }
        soldier.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STICK, 1));
        EntityAttributeInstance attackInstance = soldier.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (attackInstance != null)
            attackInstance.addPersistentModifier(new EntityAttributeModifier(MODIFIER_ID, ClayMod.MOD_ID + ":solder_stick_upgrade", 2, EntityAttributeModifier.Operation.ADDITION));
    }

    @Override
    public void onRemove(SoldierDollEntity soldier) {
        if (soldier.getWorld().isClient()) {
            return;
        }
        soldier.equipStack(EquipmentSlot.MAINHAND, null);
        EntityAttributeInstance attackInstance = soldier.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (attackInstance != null)
            attackInstance.removeModifier(MODIFIER_ID);
    }
}