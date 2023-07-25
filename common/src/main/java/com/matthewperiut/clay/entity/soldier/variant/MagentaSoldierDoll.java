package com.matthewperiut.clay.entity.soldier.variant;

import com.matthewperiut.clay.ClayMod;
import com.matthewperiut.clay.entity.soldier.SoldierDollEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class MagentaSoldierDoll extends SoldierDollEntity
{
    public static final Identifier TEXTURE_ID = new Identifier(ClayMod.MOD_ID, "textures/entity/soldier/magenta.png");

    public MagentaSoldierDoll(EntityType<? extends PathAwareEntity> type, World worldIn)
    {
        super(type, worldIn);
    }
}
