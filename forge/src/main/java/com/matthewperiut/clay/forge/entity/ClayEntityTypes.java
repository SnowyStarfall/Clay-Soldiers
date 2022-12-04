package com.matthewperiut.clay.forge.entity;

import com.matthewperiut.clay.ClayMod;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ClayEntityTypes
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
    // 1.19 DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ClayMod.MOD_ID);
            DeferredRegister.create(ForgeRegistries.ENTITIES, ClayMod.MOD_ID);

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
        SoldierDollEntities.register();
        HorseDollEntities.register();
    }
}
