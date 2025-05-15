package com.thevortex.allthemodium.items.toolitems.armor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.DispenserBlock;

public class Vib_Shield extends ShieldItem{

    public Vib_Shield(Properties p_43089_) {

        super(p_43089_);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);

    }


}
