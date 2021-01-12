package com.thevortex.allthemodium.init;

import com.thevortex.allthemodium.blocks.portals.OtherPortalTileEntity;
import com.thevortex.allthemodium.fluids.FluidList;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

public class ModEntity {

    @ObjectHolder(Reference.MOD_ID + ":other_portal")
    public static TileEntityType<OtherPortalTileEntity> OTHER_PORTAL;

    public static void init(RegistryEvent.Register<TileEntityType<?>> event) {
        OTHER_PORTAL = TileEntityType.Builder.create(OtherPortalTileEntity::new, FluidList.OTHERPORTAL_BLOCK.get()).build(null);
        OTHER_PORTAL.setRegistryName(Reference.MOD_ID, "other_portal");
        IForgeRegistry<TileEntityType<?>> registry = event.getRegistry();
        registry.register(OTHER_PORTAL);
    }
}
