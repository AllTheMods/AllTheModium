package net.allthemods.allthemodium.core.registry;

import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;

import java.util.List;

public class ATMToolMaterials {
    
    public static final ToolMaterial ALLTHEMODIUM = new ToolMaterial(
            ATMTags.Blocks.INCORRECT_FOR_ALLTHEMODIUM_TOOL,
            Short.MAX_VALUE,
            15.0F,
            12.0F,
            85,
            ATMTags.Items.INGOTS_ALLTHEMODIUM
    );
    
    public static final ToolMaterial VIBRANIUM = new ToolMaterial(
            ATMTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL,
            Short.MAX_VALUE,
            20.0F,
            25.0F,
            100,
            ATMTags.Items.INGOTS_VIBRANIUM
    );
    
    public static final ToolMaterial UNOBTAINIUM = new ToolMaterial(
            ATMTags.Blocks.INCORRECT_FOR_UNOBTAINIUM_TOOL,
            Short.MAX_VALUE,
            25.0F,
            35.0F,
            125,
            ATMTags.Items.INGOTS_UNOBTAINIUM
    );
    
    public static final ToolMaterial ALLOY = new ToolMaterial(
            ATMTags.Blocks.INCORRECT_FOR_ALLOY_TOOL,
            Short.MAX_VALUE,
            35.0F,
            65.0F,
            200,
            ATMTags.Items.INGOTS_ALLOYS
    );
    
    public static Tool createMaceTool(ToolMaterial material) {
        return new Tool(List.of(), material.speed(), 2, false);
    }
    
    public static ItemAttributeModifiers createMaceAttributes(ToolMaterial material) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, material.attackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, material.speed(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }
}
